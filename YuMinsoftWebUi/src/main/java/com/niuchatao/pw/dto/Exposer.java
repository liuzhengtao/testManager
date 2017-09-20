package com.niuchatao.pw.dto;

/**
 * 暴露秒杀链接地址
 * Created by Administrator on 2017/3/17.
 */
public class Exposer {
    //是否开启秒杀
    private boolean isExposed;
    //一种加密措施
    private String md5;

    @Override
    public String toString() {
        return "Exposer{" +
                "isExposed=" + isExposed +
                ", md5='" + md5 + '\'' +
                ", SeckillId=" + SeckillId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", nowTime=" + nowTime +
                '}';
    }

    private long SeckillId;
    //开启时间
    private long startTime;
    //结束时间
    private long endTime;
    //系统当前时间
    private long nowTime;

    public Exposer(boolean isExposed, String md5, long seckillId) {
        this.isExposed = isExposed;
        this.md5 = md5;
        SeckillId = seckillId;
    }

    public Exposer(boolean isExposed,long seckillId, long startTime, long endTime, long nowTime) {
        this.isExposed = isExposed;
        this.startTime = startTime;
        this.SeckillId = seckillId;
        this.endTime = endTime;
        this.nowTime = nowTime;
    }

    public Exposer(boolean isExposed, long seckillId) {
        this.isExposed = isExposed;
        SeckillId = seckillId;
    }

    public boolean isExposed() {
        return isExposed;
    }

    public void setExposed(boolean exposed) {
        isExposed = exposed;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public long getSeckillId() {
        return SeckillId;
    }

    public void setSeckillId(long seckillId) {
        SeckillId = seckillId;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public long getNowTime() {
        return nowTime;
    }

    public void setNowTime(long nowTime) {
        this.nowTime = nowTime;
    }
}
