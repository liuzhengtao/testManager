package com.niuchatao.pw.service.Impl;

import com.niuchatao.pw.dao.UserPageDao;
import com.niuchatao.pw.dto.UserResult;
import com.niuchatao.pw.entries.User;
import com.niuchatao.pw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户相关的服务实现类
 * Created by Administrator on 2017/3/26.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserPageDao userPageDao;

    @Override
    public User getByNameAndPwd(String name, String pwd) {
        User user = userPageDao.getByNameAndPwd(name,pwd);
        if(user!=null && !user.equals("")){
            return user;
        }
        return null;
    }



    @Override
    public User getById(int id) {

        return userPageDao.getById(id);
    }

    @Override
    public List<User> getAll() {
        return userPageDao.getAll();
    }

    @Override
    public int updateUser(User user) {
        int updateCount= userPageDao.updateUser(user);
        if(updateCount<=0){
           return 0;
        }
        return updateCount;
    }

    @Override
    public UserResult addUser(User user) {
        List list = new ArrayList();
        int addNum= userPageDao.addUser(user.getName(),user.getPwd());
        if(addNum<=0){
            return new UserResult(405,"添加失败");
        }else {
            User user1 = userPageDao.getById(addNum);
            list.add(user1);
        }
        return new UserResult(200,"添加成功",list);
    }

    @Override
    public UserResult deleteOneUser(int id) {
       int delCount = userPageDao.deleteOneUser(id);
        if(delCount<=0){
            return  new UserResult(408,"删除失败！！");
        }
         return  new UserResult(200,"删除成功！！！");
    }

}
