package com.niuchatao.pw.dto;

/**
 * Created by Administrator on 2017/3/26.
 */
public class LoginResult {
    private int state;
    private String message;
    private String name;

    public LoginResult(int state, String message) {
        this.state = state;
        this.message = message;
    }

    public LoginResult(int state, String message, String name) {
        this.state = state;
        this.message = message;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
