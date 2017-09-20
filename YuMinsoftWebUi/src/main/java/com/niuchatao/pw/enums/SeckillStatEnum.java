package com.niuchatao.pw.enums;

/**
 * 使用枚举表述常量数据
 * Created by Administrator on 2017/3/17.
 */
public enum SeckillStatEnum {
    SUCCESS(0,"秒杀成功"),
    END(1,"秒杀结束"),
    REPEAT_KILL(2,"重复秒杀"),
    INNER_ERROR(3,"系统异常"),
    DATA_REWRITE(4,"数据篡改"),
    UPDATE_SUCCESS_RESULT(200,"更新成功"),
    UPDATE_FAUIT(405,"更新成功");

    private int state;

    private String message;

    SeckillStatEnum(int stat,String message) {
        this.message = message;
        this.state = stat;
    }

    public int getStat() {
        return state;
    }

    public String getMessage() {
        return message;
    }

    public static SeckillStatEnum stateOf(int index) {
        for (SeckillStatEnum state : values()) {
            if (state.getStat() == index) {
                return state;
            }
        }
        return null;
    }
}
