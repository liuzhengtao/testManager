package com.niuchatao.pw.dao;

import com.niuchatao.pw.entries.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户操作dao
 * Created by Administrator on 2017/3/26.
 */
public interface UserPageDao {
    /**
     * 获取所有的用户信息列表
     * @return
     */
    List<User> getAll();

    /**
     * 根据用户名和密码获取用户信息
     * @param name
     * @param pwd
     * @return
     */
    User getByNameAndPwd(@Param("name") String name, @Param("pwd") String pwd);

    /**
     * 通过ID获取用户信息
     * @param id
     * @return
     */
    User getById(int id);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    int updateUser(User user);

    int addUser(@Param("name") String name, @Param("pwd") String pwd);

    /**
     * 删除用户信息
     * @param id
     * @return
     */
    int deleteOneUser(int id);
}
