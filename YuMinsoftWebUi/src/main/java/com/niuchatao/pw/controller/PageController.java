package com.niuchatao.pw.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    @RequestMapping("/getUserPage")
    public String getUserPage(HttpSession httpSession){
        try {
            if(!httpSession.getAttribute("name").equals("")|| !(httpSession.getAttribute("name") ==null)){
                return "page/userpage";
            }
            return "login";
        }catch (NullPointerException e){
            return "login";
        }
    }

    @RequestMapping("/getObjectPage")
    public String getObjectPage(HttpSession httpSession){
        try {
            if(!httpSession.getAttribute("name").equals("")|| !(httpSession.getAttribute("name") ==null)){
                return "page/objectpage";
            }
            return "login";
        }catch (NullPointerException e){
            return "login";
        }
    }


    @RequestMapping("/getLocatorPage")
    public String getLocatorPage(HttpSession httpSession){
        try {
            if(!httpSession.getAttribute("name").equals("")|| !(httpSession.getAttribute("name") ==null)){
                return "page/locatorpage";
            }
            return "login";
        }catch (NullPointerException e){
            return "login";
        }
    }

    @RequestMapping("/getStepPage")
    public String getStepPage(HttpSession httpSession){
        try {
            if(!httpSession.getAttribute("name").equals("")|| !(httpSession.getAttribute("name") ==null)){
                return "page/steppage";
            }
            return "login";
        }catch (NullPointerException e){
            return "login";
        }
    }

    @RequestMapping("/getRolePage")
    public String getRolePage(HttpSession httpSession){
        try {
            if(!httpSession.getAttribute("name").equals("")|| !(httpSession.getAttribute("name") ==null)){
                return "page/rolepage";
            }
            return "login";
        }catch (NullPointerException e){
            return "login";
        }
    }


    @RequestMapping("/getCasePage")
    public String getCasePage(HttpSession httpSession){
        try {
            if(!httpSession.getAttribute("name").equals("")|| !(httpSession.getAttribute("name") ==null)){
                return "page/casepage";
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
                return "/page/layout-2";
            }
            return "login";
        }catch (NullPointerException e){
            return "login";
        }
    }

    @RequestMapping("/getModelPage")
    public String getModelPage(HttpSession httpSession){
         try {
             if(!httpSession.getAttribute("name").equals("")|| !(httpSession.getAttribute("name") ==null)){
                 return "page/modelpage";
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
