package com.niuchatao.pw.service;

import com.niuchatao.pw.dto.UserResult;
import com.niuchatao.pw.entries.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户相关的服务接口
 * Created by Administrator on 2017/3/26.
 */
public interface UserService {
    /**
     * 通过用户名和密码获得用户对象
     * @param name
     * @param pwd
     * @return
     */
    User getByNameAndPwd(String name, String pwd);

    /**
     * 通过ID获取用户信息
     * @param id
     * @return
     */
    User getById(int id);

    /**
     * 获取所有的用户信息列表
     * @return
     */
    List<User> getAll();

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 新增用户
     * @param user
     * @return
     */
    UserResult addUser(User user);

    /**
     * 删除用户信息
     * @param id
     * @return
     */
    UserResult deleteOneUser(int id);
}
