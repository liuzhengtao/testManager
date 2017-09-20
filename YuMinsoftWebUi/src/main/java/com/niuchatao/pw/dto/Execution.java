package com.niuchatao.pw.dto;

import com.niuchatao.pw.entries.SuccessKilled;
import com.niuchatao.pw.enums.SeckillStatEnum;

/**
 * 秒杀成功以后返回结果
 * Created by Administrator on 2017/3/17.
 */
public class Execution {
    //返回状态码
    private int flat;
   //返回提示信息
    private String message;

    private long seckillId;
    //秒杀成功记录
    private SuccessKilled successKilled;

    @Override
    public String toString() {
        return "Execution{" +
                "flat=" + flat +
                ", message='" + message + '\'' +
                ", seckillId=" + seckillId +
                ", successKilled=" + successKilled +
                '}';
    }

    public Execution(long seckillId, SeckillStatEnum state, SuccessKilled successKilled) {
        this.flat = state.getStat();
        this.message = state.getMessage();
        this.successKilled = successKilled;
        this.seckillId=seckillId;
    }

    public Execution(long seckillId,SeckillStatEnum state) {
        this.seckillId = seckillId;
        this.flat = state.getStat();
        this.message = state.getMessage();
    }

    public int getFlat() {
        return flat;
    }

    public void setFlat(int flat) {
        this.flat = flat;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SuccessKilled getSuccessKilled() {
        return successKilled;
    }

    public void setSuccessKilled(SuccessKilled successKilled) {
        this.successKilled = successKilled;
    }

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }
}
