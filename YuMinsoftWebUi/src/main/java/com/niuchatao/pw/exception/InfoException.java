package com.niuchatao.pw.exception;

/**
 * Created by Administrator on 2017/3/21.
 */
public class InfoException extends SeckillException {
    public InfoException(String message) {
        super(message);
    }

    public InfoException(String message, Throwable cause) {
        super(message, cause);
    }
}
