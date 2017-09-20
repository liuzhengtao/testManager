package com.niuchatao.pw.exception;

/**
 * 重复秒杀异常
 * Created by Administrator on 2017/3/17.
 */
public class RepeatedSeckillException  extends SeckillException{
    public RepeatedSeckillException(String message) {
        super(message);
    }

    public RepeatedSeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
