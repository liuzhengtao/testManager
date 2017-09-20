package com.niuchatao.pw.controller;

import com.niuchatao.pw.dto.InfoResult;
import com.niuchatao.pw.entries.Info;
import com.niuchatao.pw.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 用户信息相关的所有控制器
 * Created by Administrator on 2017/3/21.
 */
@Controller
@RequestMapping("/infoApi")
@ResponseBody
public class PageObjectJsonController {
    @Autowired
    private InfoService infoService;

    public List<Info> getAllInfos(){
        return infoService.getAll();
    }

}
