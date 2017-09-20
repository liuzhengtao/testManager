package com.niuchatao.pw.service.Impl;

import com.niuchatao.pw.dao.SeckillDao;
import com.niuchatao.pw.dao.SuccessKilledDao;
import com.niuchatao.pw.dto.Execution;
import com.niuchatao.pw.dto.Exposer;
import com.niuchatao.pw.dto.UpdateResult;
import com.niuchatao.pw.entries.Seckill;
import com.niuchatao.pw.entries.SuccessKilled;
import com.niuchatao.pw.enums.SeckillStatEnum;
import com.niuchatao.pw.exception.RepeatedSeckillException;
import com.niuchatao.pw.exception.SeckillCloseException;
import com.niuchatao.pw.exception.SeckillException;
import com.niuchatao.pw.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/3/13.
 */
@Service
public class SeckillServiceImpl implements SeckillService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SeckillDao seckillDao;
    @Autowired
    private SuccessKilledDao successKilledDao;
    //一种加密的混淆key
    private String slat = "adeirwsdADSF@#@(*";

    @Override
    public List<Seckill> getAllSeckllList() {
        return seckillDao.queryAll(0, 10);
    }

    @Override
    public int addSeckillProduct(Seckill seckill) {
        int addCount = seckillDao.insertSeckill(seckill);
        return addCount;
    }

    @Override
    public UpdateResult updateSeckillProduct(Seckill seckill) {

          int updateCount=seckillDao.updateSeckill(seckill);
            if(updateCount<=0){
               throw new SeckillException("更新数据不成功");
            }else {
               Seckill upSeckill= seckillDao.queryById(seckill.getSeckillId());
               return new UpdateResult(SeckillStatEnum.UPDATE_SUCCESS_RESULT,upSeckill);
            }

    }

    @Override
    public Seckill queryById(long seckillId) {
        return seckillDao.queryById(seckillId);
    }

    private String getMd5(long seckillId) {
        String md5 = seckillId +"/"+ slat;
        return DigestUtils.md5DigestAsHex(md5.getBytes());
    }

    @Override
    public Exposer exposerSeckillUrl(long seckillId) {
        Seckill seckill = seckillDao.queryById(seckillId);
        Date startTime = seckill.getStartTime();
        Date endTime = seckill.getEndTime();
        Date nowTime = new Date();
        if (nowTime.getTime() > endTime.getTime()
                || nowTime.getTime() < startTime.getTime()) {
            return new Exposer(false, seckillId, startTime.getTime(), endTime.getTime(), nowTime.getTime());
        }
        //开始秒杀
        String md5 = getMd5(seckillId);
        return new Exposer(true, md5, seckillId);
    }

    @Override
    public Execution executeSeckill(long seckillId, long userPhone, String md5)
            throws SeckillException, SeckillCloseException, RepeatedSeckillException {
        if (md5 == null || !md5.equals(getMd5(seckillId))) {
            throw new SeckillException("seckill data rewrite");
        }
        try {

            //执行秒杀 减库存
            Date now = new Date();
            int updateCount = seckillDao.reduceNumber(seckillId, now);
            if (updateCount <= 0) {
                throw new SeckillCloseException("seckill is closed");
            } else {
                //添加秒杀成功记录
                int state =0;
                int insertCount = successKilledDao.insertSuccessKilled(seckillId, userPhone,state);
                if (insertCount <= 0) {
                    throw new RepeatedSeckillException("seckill repeate");
                }
                SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(seckillId);
                return new Execution(seckillId, SeckillStatEnum.SUCCESS, successKilled);
            }
        } catch (RepeatedSeckillException e1) {
            throw e1;
        } catch (SeckillCloseException e2) {
            throw e2;
        } catch (Exception e) {
            logger.error("秒杀系统内部错误:" + e.getMessage());
            throw new SeckillException("seckill inner error");
        }

    }

}
