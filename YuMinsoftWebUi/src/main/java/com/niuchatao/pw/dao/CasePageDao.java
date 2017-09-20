package com.niuchatao.pw.dao;

import com.niuchatao.pw.entries.Seckill;
import org.apache.ibatis.annotations.Param;


import java.util.Date;
import java.util.List;

/**
 * 秒杀商品dao
 * Created by 刘正涛 on 2017/2/19.
 */
public interface CasePageDao {
    /**
     * 减库存
     * @param seckillId
     * @param killTime
     * @return
     */
    int reduceNumber(@Param("seckillId") long seckillId, @Param("killTime") Date killTime);

    /**
     *根据id查询秒杀对象
     * @param seckillId
     * @return
     */
    Seckill queryById(long seckillId);

    /**
     * 根据偏移量查询秒杀商品列表
     * @param offset
     * @param limit
     * @return
     */
    List<Seckill> queryAll(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 新增秒杀商品dao
     * @return
     */
    int insertSeckill(Seckill seckill);

    /**
     * 更新秒杀商品信息
     * @param seckill
     * @return
     */
    int updateSeckill(Seckill seckill);

    /**
     * 更新秒杀商品信息
     * @param name
     * @param number
     * @param startTime
     * @param endTime
     * @param createTime
     * @return
     */
   // int updateSeckill(@Param("name")String name,@Param("number")Integer number,@Param("startTime") Date startTime,@Param("endTime") Date endTime,@Param("createTime") Date createTime,@Param("seckillId") long seckillId);
}
