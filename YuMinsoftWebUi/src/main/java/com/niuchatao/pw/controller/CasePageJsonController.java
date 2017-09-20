package com.niuchatao.pw.controller;

import com.niuchatao.pw.dto.LoginResult;
import com.niuchatao.pw.dto.UserResult;
import com.niuchatao.pw.entries.Seckill;
import com.niuchatao.pw.entries.User;
import com.niuchatao.pw.service.Impl.SeckillServiceImpl;
import com.niuchatao.pw.service.SeckillService;
import com.niuchatao.pw.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2017/3/13.
 */
@Controller
@RequestMapping("/seckill")
@ResponseBody
public class CasePageJsonController {

    @Autowired
    private UserService userService;




    @RequestMapping(value = "/getJson")
    public String get_json(){
        String str = "{\"total\":13,\"rows\":[\n" +
                "\t{\"productid\":\"FI-SW-01\",\"productname\":\"Koi\",\"unitcost\":10.00,\"status\":\"P\",\"listprice\":36.50,\"attr1\":\"Large\",\"itemid\":\"EST-1\"},\n" +
                "\t{\"productid\":\"K9-DL-01\",\"productname\":\"Dalmation\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":18.50,\"attr1\":\"Spotted Adult Female\",\"itemid\":\"EST-10\"},\n" +
                "\t{\"productid\":\"RP-SN-01\",\"productname\":\"Rattlesnake\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":38.50,\"attr1\":\"Venomless\",\"itemid\":\"EST-11\"},\n" +
                "\t{\"productid\":\"RP-SN-01\",\"productname\":\"Rattlesnake\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":26.50,\"attr1\":\"Rattleless\",\"itemid\":\"EST-12\"},\n" +
                "\t{\"productid\":\"RP-LI-02\",\"productname\":\"Iguana\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":35.50,\"attr1\":\"Green Adult\",\"itemid\":\"EST-13\"},\n" +
                "\t{\"productid\":\"FL-DSH-01\",\"productname\":\"Manx\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":158.50,\"attr1\":\"Tailless\",\"itemid\":\"EST-14\"},\n" +
                "\t{\"productid\":\"FL-DSH-01\",\"productname\":\"Manx\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":83.50,\"attr1\":\"With tail\",\"itemid\":\"EST-15\"},\n" +
                "\t{\"productid\":\"FL-DLH-02\",\"productname\":\"Persian\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":23.50,\"attr1\":\"Adult Female\",\"itemid\":\"EST-16\"},\n" +
                "\t{\"productid\":\"FL-DLH-02\",\"productname\":\"Persian\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":89.50,\"attr1\":\"Adult Male\",\"itemid\":\"EST-17\"},\n" +
                "\t{\"productid\":\"AV-CB-01\",\"productname\":\"Amazon Parrot\",\"unitcost\":92.00,\"status\":\"P\",\"listprice\":63.50,\"attr1\":\"Adult Male\",\"itemid\":\"EST-18\"}\n" +
                "]}";
        return str;
    }
    @RequestMapping(value = "/getMenu")
    public String get_menu(){
        String str = "[{\n" +
                "\t\"id\":1,\n" +
                "    \"text\":\"首页\",\n" +
                "    \"state\":\"\",\n" +
                "    \"attributes\":{\n" +
                "\t\t\"url\":\"\",\n" +
                "\t\t\"iframe\":\"\"\n" +
                "\t},\n" +
                "    \"children\":[{\n" +
                "    \t\"id\":2,\n" +
                "        \"text\":\"系统管理\",\n" +
                "        \"state\":\"\",\n" +
                "        \"attributes\":{\n" +
                "            \"url\":\"\",\n" +
                "\t\t\t\"iframe\":\"\"\n" +
                "        },\n" +
                "        \"children\":[{\n" +
                "        \t\"id\":3,\n" +
                "        \t\"text\":\"用户管理\",\n" +
                "            \"state\":\"\",\n" +
                "            \"attributes\":{\n" +
                "                \"url\":\"datagrid.html\",\n" +
                "\t\t\t\t\"iframe\":\"\"\n" +
                "            }\n" +
                "        },{\n" +
                "        \t\"id\":4,\n" +
                "        \t\"text\":\"角色管理\",\n" +
                "            \"state\":\"\",\n" +
                "            \"attributes\":{\n" +
                "                \"url\":\"_content.html\",\n" +
                "\t\t\t\t\"iframe\":\"\"\n" +
                "            }\n" +
                "        },{\n" +
                "        \t\"id\":5,\n" +
                "        \t\"text\":\"菜单管理\",\n" +
                "            \"state\":\"\",\n" +
                "            \"attributes\":{\n" +
                "                \"url\":\"datagrid.html\",\n" +
                "\t\t\t\t\"iframe\":\"\"\n" +
                "            }\n" +
                "        },{\n" +
                "        \t\"id\":6,\n" +
                "        \t\"text\":\"权限管理\",\n" +
                "            \"state\":\"\",\n" +
                "            \"attributes\":{\n" +
                "                \"url\":\"http://www.baidu.com\",\n" +
                "\t\t\t\t\"iframe\":\"true\"\n" +
                "            }\n" +
                "        }]\n" +
                "    }]\n" +
                "}]";
        return str;
    }

    @RequestMapping("/getDataGrid")
    public String get_dataGrid(){
        String str = "{\n" +
                "\t\"total\":50,\n" +
                "\t\"rows\":[\n" +
                "\t{\"productid\":\"FI-SW-01\",\"productname\":\"Koi\",\"unitcost\":10.00,\"status\":\"P\",\"listprice\":36.50,\"attr1\":\"Large\",\"itemid\":\"EST-1\"},\n" +
                "\t{\"productid\":\"K9-DL-01\",\"productname\":\"Dalmation\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":18.50,\"attr1\":\"Spotted Adult Female\",\"itemid\":\"EST-10\"},\n" +
                "\t{\"productid\":\"RP-SN-01\",\"productname\":\"Rattlesnake\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":38.50,\"attr1\":\"Venomless\",\"itemid\":\"EST-11\"},\n" +
                "\t{\"productid\":\"RP-SN-01\",\"productname\":\"Rattlesnake\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":26.50,\"attr1\":\"Rattleless\",\"itemid\":\"EST-12\"},\n" +
                "\t{\"productid\":\"RP-LI-02\",\"productname\":\"Iguana\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":35.50,\"attr1\":\"Green Adult\",\"itemid\":\"EST-13\"},\n" +
                "\t{\"productid\":\"FI-SW-01\",\"productname\":\"Koi\",\"unitcost\":10.00,\"status\":\"P\",\"listprice\":36.50,\"attr1\":\"Large\",\"itemid\":\"EST-1\"},\n" +
                "\t{\"productid\":\"K9-DL-01\",\"productname\":\"Dalmation\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":18.50,\"attr1\":\"Spotted Adult Female\",\"itemid\":\"EST-10\"},\n" +
                "\t{\"productid\":\"RP-SN-01\",\"productname\":\"Rattlesnake\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":38.50,\"attr1\":\"Venomless\",\"itemid\":\"EST-11\"},\n" +
                "\t{\"productid\":\"RP-SN-01\",\"productname\":\"Rattlesnake\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":26.50,\"attr1\":\"Rattleless\",\"itemid\":\"EST-12\"},\n" +
                "\t{\"productid\":\"RP-LI-02\",\"productname\":\"Iguana\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":35.50,\"attr1\":\"Green Adult\",\"itemid\":\"EST-13\"},\n" +
                "\t{\"productid\":\"FI-SW-01\",\"productname\":\"Koi\",\"unitcost\":10.00,\"status\":\"P\",\"listprice\":36.50,\"attr1\":\"Large\",\"itemid\":\"EST-1\"},\n" +
                "\t{\"productid\":\"K9-DL-01\",\"productname\":\"Dalmation\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":18.50,\"attr1\":\"Spotted Adult Female\",\"itemid\":\"EST-10\"},\n" +
                "\t{\"productid\":\"RP-SN-01\",\"productname\":\"Rattlesnake\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":38.50,\"attr1\":\"Venomless\",\"itemid\":\"EST-11\"},\n" +
                "\t{\"productid\":\"RP-SN-01\",\"productname\":\"Rattlesnake\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":26.50,\"attr1\":\"Rattleless\",\"itemid\":\"EST-12\"},\n" +
                "\t{\"productid\":\"RP-LI-02\",\"productname\":\"Iguana\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":35.50,\"attr1\":\"Green Adult\",\"itemid\":\"EST-13\"},\n" +
                "\t{\"productid\":\"FI-SW-01\",\"productname\":\"Koi\",\"unitcost\":10.00,\"status\":\"P\",\"listprice\":36.50,\"attr1\":\"Large\",\"itemid\":\"EST-1\"},\n" +
                "\t{\"productid\":\"K9-DL-01\",\"productname\":\"Dalmation\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":18.50,\"attr1\":\"Spotted Adult Female\",\"itemid\":\"EST-10\"},\n" +
                "\t{\"productid\":\"RP-SN-01\",\"productname\":\"Rattlesnake\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":38.50,\"attr1\":\"Venomless\",\"itemid\":\"EST-11\"},\n" +
                "\t{\"productid\":\"RP-SN-01\",\"productname\":\"Rattlesnake\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":26.50,\"attr1\":\"Rattleless\",\"itemid\":\"EST-12\"},\n" +
                "\t{\"productid\":\"RP-LI-02\",\"productname\":\"Iguana\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":35.50,\"attr1\":\"Green Adult\",\"itemid\":\"EST-13\"},\n" +
                "\t{\"productid\":\"FI-SW-01\",\"productname\":\"Koi\",\"unitcost\":10.00,\"status\":\"P\",\"listprice\":36.50,\"attr1\":\"Large\",\"itemid\":\"EST-1\"},\n" +
                "\t{\"productid\":\"K9-DL-01\",\"productname\":\"Dalmation\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":18.50,\"attr1\":\"Spotted Adult Female\",\"itemid\":\"EST-10\"},\n" +
                "\t{\"productid\":\"RP-SN-01\",\"productname\":\"Rattlesnake\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":38.50,\"attr1\":\"Venomless\",\"itemid\":\"EST-11\"},\n" +
                "\t{\"productid\":\"RP-SN-01\",\"productname\":\"Rattlesnake\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":26.50,\"attr1\":\"Rattleless\",\"itemid\":\"EST-12\"},\n" +
                "\t{\"productid\":\"RP-LI-02\",\"productname\":\"Iguana\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":35.50,\"attr1\":\"Green Adult\",\"itemid\":\"EST-13\"},\n" +
                "\t{\"productid\":\"FL-DSH-01\",\"productname\":\"Manx\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":158.50,\"attr1\":\"Tailless\",\"itemid\":\"EST-14\"},\n" +
                "\t{\"productid\":\"FL-DSH-01\",\"productname\":\"Manx\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":83.50,\"attr1\":\"With tail\",\"itemid\":\"EST-15\"},\n" +
                "\t{\"productid\":\"FL-DLH-02\",\"productname\":\"Persian\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":23.50,\"attr1\":\"Adult Female\",\"itemid\":\"EST-16\"},\n" +
                "\t{\"productid\":\"FL-DLH-02\",\"productname\":\"Persian\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":89.50,\"attr1\":\"Adult Male\",\"itemid\":\"EST-17\"},\n" +
                "\t{\"productid\":\"AV-CB-01\",\"productname\":\"Amazon Parrot\",\"unitcost\":92.00,\"status\":\"P\",\"listprice\":63.50,\"attr1\":\"Adult Male\",\"itemid\":\"EST-18\"},\n" +
                "\t{\"productid\":\"FI-SW-01\",\"productname\":\"Koi\",\"unitcost\":10.00,\"status\":\"P\",\"listprice\":36.50,\"attr1\":\"Large\",\"itemid\":\"EST-1\"},\n" +
                "\t{\"productid\":\"K9-DL-01\",\"productname\":\"Dalmation\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":18.50,\"attr1\":\"Spotted Adult Female\",\"itemid\":\"EST-10\"},\n" +
                "\t{\"productid\":\"RP-SN-01\",\"productname\":\"Rattlesnake\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":38.50,\"attr1\":\"Venomless\",\"itemid\":\"EST-11\"},\n" +
                "\t{\"productid\":\"RP-SN-01\",\"productname\":\"Rattlesnake\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":26.50,\"attr1\":\"Rattleless\",\"itemid\":\"EST-12\"},\n" +
                "\t{\"productid\":\"RP-LI-02\",\"productname\":\"Iguana\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":35.50,\"attr1\":\"Green Adult\",\"itemid\":\"EST-13\"},\n" +
                "\t{\"productid\":\"FL-DSH-01\",\"productname\":\"Manx\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":158.50,\"attr1\":\"Tailless\",\"itemid\":\"EST-14\"},\n" +
                "\t{\"productid\":\"FL-DSH-01\",\"productname\":\"Manx\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":83.50,\"attr1\":\"With tail\",\"itemid\":\"EST-15\"},\n" +
                "\t{\"productid\":\"FL-DLH-02\",\"productname\":\"Persian\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":23.50,\"attr1\":\"Adult Female\",\"itemid\":\"EST-16\"},\n" +
                "\t{\"productid\":\"FL-DLH-02\",\"productname\":\"Persian\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":89.50,\"attr1\":\"Adult Male\",\"itemid\":\"EST-17\"},\n" +
                "\t{\"productid\":\"AV-CB-01\",\"productname\":\"Amazon Parrot\",\"unitcost\":92.00,\"status\":\"P\",\"listprice\":63.50,\"attr1\":\"Adult Male\",\"itemid\":\"EST-18\"},\n" +
                "\t{\"productid\":\"FI-SW-01\",\"productname\":\"Koi\",\"unitcost\":10.00,\"status\":\"P\",\"listprice\":36.50,\"attr1\":\"Large\",\"itemid\":\"EST-1\"},\n" +
                "\t{\"productid\":\"K9-DL-01\",\"productname\":\"Dalmation\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":18.50,\"attr1\":\"Spotted Adult Female\",\"itemid\":\"EST-10\"},\n" +
                "\t{\"productid\":\"RP-SN-01\",\"productname\":\"Rattlesnake\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":38.50,\"attr1\":\"Venomless\",\"itemid\":\"EST-11\"},\n" +
                "\t{\"productid\":\"RP-SN-01\",\"productname\":\"Rattlesnake\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":26.50,\"attr1\":\"Rattleless\",\"itemid\":\"EST-12\"},\n" +
                "\t{\"productid\":\"RP-LI-02\",\"productname\":\"Iguana\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":35.50,\"attr1\":\"Green Adult\",\"itemid\":\"EST-13\"},\n" +
                "\t{\"productid\":\"FL-DSH-01\",\"productname\":\"Manx\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":158.50,\"attr1\":\"Tailless\",\"itemid\":\"EST-14\"},\n" +
                "\t{\"productid\":\"FL-DSH-01\",\"productname\":\"Manx\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":83.50,\"attr1\":\"With tail\",\"itemid\":\"EST-15\"},\n" +
                "\t{\"productid\":\"FL-DLH-02\",\"productname\":\"Persian\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":23.50,\"attr1\":\"Adult Female\",\"itemid\":\"EST-16\"},\n" +
                "\t{\"productid\":\"FL-DLH-02\",\"productname\":\"Persian\",\"unitcost\":12.00,\"status\":\"P\",\"listprice\":89.50,\"attr1\":\"Adult Male\",\"itemid\":\"EST-17\"},\n" +
                "\t{\"productid\":\"AV-CB-01\",\"productname\":\"Amazon Parrot\",\"unitcost\":92.00,\"status\":\"P\",\"listprice\":63.50,\"attr1\":\"Adult Male\",\"itemid\":\"EST-18\"}\n" +
                "\t]\n" +
                "}";
        return str;
    }



    /*
    @RequestMapping(value = "/insertInfo")
    public String addSeckillInfo(String name,String number,String startTime,String endTime,Model model){
        int insertId = seckillServiceImpl.insertInfo(name,number,startTime,endTime);
        model.addAttribute("insertId",insertId);
        return "success";
    }

    @RequestMapping(value = "/insert")
    public String showInsertPage(){
        return "insert";
    }

    @RequestMapping(value = "/update")
    public String showupdatePage( @RequestParam String seckillId,Model model){
        Seckill seckill = seckillServiceImpl.queryById(seckillId);
        model.addAttribute("seckill",seckill);
        return "update";
    }
    @RequestMapping(value = "/updateInfo")
    public String updateInfo( String name,String number, String startTime, String endTime, String seckillId,Model model){
        int updateId = seckillServiceImpl.updateSeckill(name,number,startTime,endTime,seckillId);
        model.addAttribute("insertId",updateId);
        return "success";
    }*/
}
