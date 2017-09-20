package com.niuchatao.pw.service;

import com.niuchatao.pw.dto.Execution;
import com.niuchatao.pw.dto.Exposer;
import com.niuchatao.pw.dto.UpdateResult;
import com.niuchatao.pw.entries.Seckill;
import com.niuchatao.pw.exception.RepeatedSeckillException;
import com.niuchatao.pw.exception.SeckillCloseException;
import com.niuchatao.pw.exception.SeckillException;

import java.util.List;

/**
 * 秒杀相关的服务接口
 * Created by liuzhengtao on 2017/3/17.
 */
public interface SeckillService {
    /**
     * 获得所有的秒杀商品列表
     *
     * @return
     */
    List<Seckill> getAllSeckllList();

    /**
     * 添加秒杀商品
     * @param seckill
     * @return
     */
    int addSeckillProduct(Seckill seckill);

    /**
     * 更新秒杀商品信息
     * @param seckill
     * @return
     */
    UpdateResult updateSeckillProduct(Seckill seckill);

    /**
     * 获取单个秒杀商品
     *
     * @param seckillId
     * @return
     */
    Seckill queryById(long seckillId);

    /**
     * 秒杀开启暴露url
     * 否者输出系统时间和秒杀时间
     *
     * @param seckillId
     * @return
     */
    Exposer exposerSeckillUrl(long seckillId);

    /**
     * 执行秒杀操作
     *
     * @param seckillId
     * @param userPhone
     * @param md5
     */
    Execution executeSeckill(long seckillId, long userPhone, String md5)
    throws SeckillException,SeckillCloseException,RepeatedSeckillException;
}
