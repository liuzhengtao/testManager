package com.niuchatao.pw.service;

import com.niuchatao.pw.entries.Info;

import java.util.List;

/**
 * 用户信息相关的操作
 * Created by Administrator on 2017/3/20.
 */
public interface InfoService {
    /**
     * 获得所有的用户列表
     * @return
     */
    List<Info> getAll();

    /**
     * 获得一条用户信息
     * @param id
     * @return
     */
    Info getById(int id);


    int insertIntoTable(Info info);


}
