package com.niuchatao.pw.dto;

import com.niuchatao.pw.entries.Info;
import com.niuchatao.pw.enums.InfoStatEnum;

/**
 * 用户信息操作返回结果
 * Created by Administrator on 2017/3/21.
 */
public class InfoResult {

    private int state;

    private String message;

    public InfoResult(InfoStatEnum infoStateEnum, Info info) {
        this.state = infoStateEnum.getStat();
        this.message = infoStateEnum.getMessage();
        this.info = info;
    }

    private  int id;

    private Info info;

    public InfoResult(InfoStatEnum infoStateEnum) {
        this.state = infoStateEnum.getStat();
        this.message = infoStateEnum.getMessage();
        this.id = id;
    }

    public InfoResult(InfoStatEnum infoStateEnum, int id) {
        this.state = infoStateEnum.getStat();
        this.message = infoStateEnum.getMessage();
        this.id = id;
    }

    public InfoResult(InfoStatEnum infoStateEnum, int id, Info info) {
        this.state = infoStateEnum.getStat();
        this.message = infoStateEnum.getMessage();
        this.id = id;
        this.info = info;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "InfoResult{" +
                "state=" + state +
                ", message='" + message + '\'' +
                ", id=" + id +
                ", info=" + info +
                '}';
    }
}
