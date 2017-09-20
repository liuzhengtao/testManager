package com.niuchatao.pw.dto;

import com.niuchatao.pw.entries.Seckill;
import com.niuchatao.pw.enums.SeckillStatEnum;

/**
 * 更新结果返回参数
 * Created by Administrator on 2017/3/18.
 */
public class UpdateResult {
    //更新数
    private  int state;

    private String message;

    private Seckill seckill;

    public UpdateResult(SeckillStatEnum seckillStatEnum) {
        this.state = seckillStatEnum.getStat();
        this.message = seckillStatEnum.getMessage();
    }

    public UpdateResult(SeckillStatEnum seckillStatEnum, Seckill seckill) {
        this.state = seckillStatEnum.getStat();
        this.message = seckillStatEnum.getMessage();
        this.seckill = seckill;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Seckill getSeckill() {
        return seckill;
    }

    public void setSeckill(Seckill seckill) {
        this.seckill = seckill;
    }
}
