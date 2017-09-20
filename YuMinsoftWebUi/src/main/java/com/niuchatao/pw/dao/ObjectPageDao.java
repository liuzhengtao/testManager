package com.niuchatao.pw.dao;


import com.niuchatao.pw.entries.SuccessKilled;
import org.apache.ibatis.annotations.Param;

/**
 * Created by 刘正涛 on 2017/2/19.
 */
public interface ObjectPageDao {
    /**
     * 插入购买明细，可过滤重复
     * @param seckillId
     * @param userPhone
     * @return
     */
    int insertSuccessKilled(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone, @Param("state") int state);

    /**
     * 根据id查询SuccessKilled并携带秒杀产品对象实体
     * @param seckillId
     * @return
     */
    SuccessKilled queryByIdWithSeckill(long seckillId);
}
