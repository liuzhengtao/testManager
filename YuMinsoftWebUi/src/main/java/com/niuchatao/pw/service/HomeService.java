package com.niuchatao.pw.service;

import com.niuchatao.pw.dao.SeckillDao;
import com.niuchatao.pw.entries.Seckill;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/13.
 */
@Service
public class HomeService {

    @Resource
    private SeckillDao seckillDao;
    Seckill seckill=null;
    public Seckill queryId(String id){

        if(!id.equals("")||id!=null){
          seckill = seckillDao.queryById(Integer.valueOf(id));
        }
        return seckill;
    }

    public List<Seckill> queryAll(String offset,String limit){
         List<Seckill> list = new ArrayList<Seckill>();
        if(!offset.equals("")||offset!=null){
            if(!limit.equals("")||limit!=null){
            list = seckillDao.queryAll(Integer.valueOf(offset),Integer.valueOf(limit));
            }
        }
        return list;
    }

}
