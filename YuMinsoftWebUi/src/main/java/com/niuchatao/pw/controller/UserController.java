package com.niuchatao.pw.controller;

import com.niuchatao.pw.dto.LoginResult;
import com.niuchatao.pw.dto.UserResult;
import com.niuchatao.pw.entries.User;
import com.niuchatao.pw.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/26.
 */
@RequestMapping("/user")
@Controller
@ResponseBody
public class UserController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/doLogin",method = RequestMethod.POST)
    public LoginResult doLogin(String name, String pwd, HttpSession httpSession){
        User user = userService.getByNameAndPwd(name, DigestUtils.md5DigestAsHex(pwd.getBytes()));
        if(user!=null){
            if(name.equals(user.getName())&&DigestUtils.md5DigestAsHex(pwd.getBytes()).equals(user.getPwd())){
                httpSession.setAttribute("name",name);
                httpSession.setMaxInactiveInterval(60*60);
                return new LoginResult(200,"请求成功");
            }
            return new LoginResult(402,"你输入的用户名或者密码不存在");
        }

        return new LoginResult(402,"你输入的用户名或者密码不存在");
    }
    @RequestMapping(value = "/getAll")
    public UserResult getlist(HttpSession httpSession){
          logger.info((String) httpSession.getAttribute("name"));
        try {
            if(httpSession.getAttribute("name") != null || !httpSession.getAttribute("name").equals("")){
                List list= userService.getAll();
                return new UserResult(200,"请求成功", list);
            }else {
                return new UserResult(403,"请先登录！！！");
            }
        }catch (NullPointerException e){
            return new UserResult(403,"请先登录！！！");
        }

    }
    @RequestMapping(value = "/getAllUsers")
    public  List<User> getAllUsers(){
        List<User> list= userService.getAll();
        return list;
    }
    @RequestMapping(value = "/getOneUser")
    public  User getOneUser(int id){
        User user= userService.getById(id);
        if(user==null){
           return null;
        }
        return user;
    }

    @RequestMapping(value = "/updateUser")
    public  UserResult updateUser(int id,String name,String pwd){
        if(!name.equals("")){
            User user= new User();
            user.setId(id);
            user.setName(name);
            user.setPwd(DigestUtils.md5DigestAsHex(pwd.getBytes()));
            int updateCount =userService.updateUser(user);
            if(updateCount!=0){
                User UpdateUser = userService.getById((int) user.getId());
                List<User> users = new ArrayList<User>();
                users.add(UpdateUser);
                return new UserResult(200,"更新成功",users);
            }
            return new UserResult(401,"更新失败");
        }
        return new UserResult(401,"更新失败");
    }
    @RequestMapping(value = "/addUser")
    public UserResult addUser(String name,String pwd){
        User user= new User();
        user.setName(name);
        user.setPwd(DigestUtils.md5DigestAsHex(pwd.getBytes()));
       return userService.addUser(user);
    }

    @RequestMapping(value = "/deleteOneUser")
    public UserResult deleteOneUser(int id){
        return userService.deleteOneUser(id);
    }
}
