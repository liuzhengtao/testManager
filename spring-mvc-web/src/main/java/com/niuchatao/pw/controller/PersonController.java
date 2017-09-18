package com.niuchatao.pw.controller;

import com.niuchatao.pw.entries.Info;
import com.niuchatao.pw.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reponse.ResponseBase;
import reponse.ResponsePersion;

import javax.annotation.Resource;
import java.util.List;

@RestController
@ResponseBody
public class PersonController {

    @Resource
    public InfoService infoService;
    private Info info;
    private ResponseBase responseBase;
    private ResponsePersion responsePersion;
    @RequestMapping(value = "/fo/foLoanInfo/personValidate",method= RequestMethod.POST)
    public ResponseBase personValidate(@RequestParam("idNo") String idNo){
        responseBase = new ResponseBase();
        info = infoService.getById(1);
        if(info!=null){
            responseBase.setFlag(Boolean.parseBoolean(info.getValideFlag()));
        }else{
            return null;
        }
        return  responseBase ;
    }
    @RequestMapping(value = "/foBaseInfoApi/getSalesman")
    public ResponseBase getSalesman(@RequestParam("idNum") String idNum,@RequestParam("name") String name){
        responsePersion = new ResponsePersion();
        info = infoService.getById(1);
        if(info!=null){
            if(info.getSaleFlag().equals("Y")){
                responsePersion.setFlag(info.getSaleFlag());
                responsePersion.setUserCode(info.getUserCode());
                return responsePersion;
            }else{
                responseBase = new ResponseBase();
                responseBase.setFlag(info.getSaleFlag());
                return responseBase;
            }

        }
       return null;
    }

    @RequestMapping(value = "/getAll")
    public List<Info> getAll(){
        return infoService.getAll();
    }



}
