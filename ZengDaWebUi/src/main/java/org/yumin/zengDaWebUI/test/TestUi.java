package org.yumin.zengDaWebUI.test;

import com.google.gson.Gson;
import com.google.gson.internal.LazilyParsedNumber;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.yumin.zengDaWebUI.dao.UiDao;
import org.yumin.zengDaWebUI.dao.impl.UiDaoImpl;
import org.yumin.zengDaWebUI.entries.PageInfo;
import org.yumin.zengDaWebUI.utils.TestBaseCase;

import javax.annotation.Resource;
import java.net.MalformedURLException;

/**
 * Created by 刘正涛 on 2017/9/12.
 */
public class TestUi{


    private UiDaoImpl uiDao = new UiDaoImpl();
    Gson gson = new Gson();

    @Test
    public void test1(){
       sayOUT("管理系统");
    }

    public void sayOUT(String exceptStr ){
         exceptStr="//*[text()=\'"+exceptStr+"\']";
         System.out.println(exceptStr);
    }

}
