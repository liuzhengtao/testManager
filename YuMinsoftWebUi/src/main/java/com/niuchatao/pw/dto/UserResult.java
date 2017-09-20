package com.niuchatao.pw.dto;

import com.niuchatao.pw.entries.User;

import java.util.List;

/**
 * Created by Administrator on 2017/3/26.
 */
public class UserResult {

    private int state;

    private String message;

    private List<User> user;

    public UserResult(int state, String message) {
        this.state = state;
        this.message = message;
    }

    public UserResult(int state, String message, List<User> user) {
        this.state = state;
        this.message = message;
        this.user = user;
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

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }
}
