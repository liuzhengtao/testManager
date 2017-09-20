package com.niuchatao.pw.exception;

/**
 * 秒杀系统异常
 * Created by Administrator on 2017/3/17.
 */
public class SeckillException extends RuntimeException{
    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
