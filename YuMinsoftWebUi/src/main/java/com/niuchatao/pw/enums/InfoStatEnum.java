package com.niuchatao.pw.enums;

/**
 * 用户信息操作结果状态枚举值
 * Created by Administrator on 2017/3/21.
 */
public enum InfoStatEnum {

    INFO_SUCCESS(200,"请求成功"),
    ADD_SUCCESS(202,"添加成功"),
    UPDATE_SUCCESS(204,"更新成功"),
    DEL_SUCCESS(206,"删除成功"),
    INFO_ERROR(400,"信息错误"),
    ADD_FAIL(402,"添加失败"),
    UPDATE_FAIL(406,"更新失败"),
    DEL_FAIL(408,"删除失败");

    private int state;

    private String message;

    InfoStatEnum(int stat,String message) {
        this.message = message;
        this.state = stat;
    }

    public int getStat() {
        return state;
    }

    public String getMessage() {
        return message;
    }

    public static InfoStatEnum stateOf(int index) {
        for (InfoStatEnum state : values()) {
            if (state.getStat() == index) {
                return state;
            }
        }
        return null;
    }
}
