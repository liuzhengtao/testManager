package com.niuchatao.pw.controller;

import com.niuchatao.pw.entries.Info;
import com.niuchatao.pw.service.InfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 刘正涛 on 2017/7/29.
 */
@Controller
public class PageController {
    private Logger logger = LoggerFactory.getLogger(PageController.class);
    @Resource
    public InfoService infoService;

    @RequestMapping(value = "/showPage")
    public String display(Model model){
        Info info=infoService.getById(1);
        model.addAttribute("info",info);
        logger.info(info.toString());
        System.out.println("---------------"+info+"------------------------");
        return "showpage";
    }

}
