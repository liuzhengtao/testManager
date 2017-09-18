package com.niuchatao.pw.dao;

import com.niuchatao.pw.entries.Info;

import java.util.List;

/**
 * 用户信息操作DAO
 * Created by Administrator on 2017/3/20.
 */
public interface InfoDao {
    /**
     * 通过id获得用户信息
     * @param id
     * @return
     */
    Info getInfo(int id);

    /**
     * 获得所有的用户信息列表
     * @return
     */
    List<Info> getAllInfos();

    /**
     * 新增用户信息对象
     * @param info
     * @return
     */
    int insertInfo(Info info);

    /**
     * 修改用户信息对象
     * @param info
     * @return
     */
    int updateInfo(Info info);

    /**
     * 删除用户信息
     * @param id
     * @return
     */
    int deleteInfo(int id);

}
