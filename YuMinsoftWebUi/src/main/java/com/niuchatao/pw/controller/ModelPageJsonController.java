package com.niuchatao.pw.controller;

import com.niuchatao.pw.entries.Seckill;
import com.niuchatao.pw.service.HomeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/3/13.
 */
@Controller
public class ModelPageJsonController {
    @Resource
    private HomeService homeService;

    @RequestMapping(value = "/getHome")
    public String getHomePage(Model model){
        String offset = "1",limit="3";
        List<Seckill> list=homeService.queryAll(offset,limit);
        model.addAttribute("list",list);
        return "home";
    }
}
