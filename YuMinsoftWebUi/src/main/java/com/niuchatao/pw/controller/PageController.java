package com.niuchatao.pw.controller;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * 页面跳转的控制器
 * Created by Administrator on 2017/3/20.
 */
@Controller
@RequestMapping("/page")
public class PageController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @RequestMapping(value = "/returnPage")
    public String getlistPage(HttpSession httpSession){
        try {
            if(!httpSession.getAttribute("name").equals("")|| !(httpSession.getAttribute("name") ==null)){

                return "index";
            }
            return "login";
        }catch (NullPointerException e){
            return "login";
        }
    }

    @RequestMapping("/getlayout1")
    public String getLayout1(HttpSession httpSession){
        try {
            if(!httpSession.getAttribute("name").equals("")|| !(httpSession.getAttribute("name") ==null)){
                return "/temp/layout-1";
            }
            return "login";
        }catch (NullPointerException e){
            return "login";
        }
    }

    @RequestMapping("/getlayout2")
    public String getLayout2(HttpSession httpSession){
        try {
            if(!httpSession.getAttribute("name").equals("")|| !(httpSession.getAttribute("name") ==null)){
                return "/temp/layout-2";
            }
            return "login";
        }catch (NullPointerException e){
            return "login";
        }
    }

    @RequestMapping("/getlayout3")
    public String getLayout3(HttpSession httpSession){
         try {
             if(!httpSession.getAttribute("name").equals("")|| !(httpSession.getAttribute("name") ==null)){
                 return "/temp/layout-3";
             }
             return "login";
         }catch (NullPointerException e){
             return "login";
         }

    }

    @RequestMapping("/doLogin")
    public String doLogin(HttpSession httpSession,Model model){
        try {
            if(!httpSession.getAttribute("name").equals("")||httpSession.getAttribute("name")!=null){
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date d = new Date();
               String date = format.format(d);
                String[] weeks = new String[]{"星期天","星期一","星期二","星期三","星期四","星期五","星期六"};
                String week = weeks[d.getDay()];
                model.addAttribute("name",httpSession.getAttribute("name"));
                model.addAttribute("week",week);
                return "index";
            }
            return "login";
        }catch (NullPointerException e){
            return "login";
        }

    }
    @RequestMapping("/quitLogin")
    public String quitLogin(HttpSession httpSession){
        httpSession.invalidate();
        return "login";
    }

}
