package org.yumin.zengDaWebUI.test;

import com.google.gson.Gson;
import org.testng.annotations.Test;
import org.yumin.zengDaWebUI.dao.impl.UiDaoImpl;
import org.yumin.zengDaWebUI.entries.LocatorInfo;
import org.yumin.zengDaWebUI.entries.PageInfo;
import org.yumin.zengDaWebUI.pageObject.LoginPage;
import org.yumin.zengDaWebUI.entries.Log;

import java.util.HashMap;
import java.util.List;

/**
 * Created by 刘正涛 on 2017/9/12.
 */
public class TestUi{

    Log log = new Log(this.getClass());

    private UiDaoImpl uiDao = new UiDaoImpl();
    Gson gson = new Gson();

    @Test
    public void test1(){
       sayOUT();
    }

    public void sayOUT(){
        HashMap<String, LocatorInfo> locatorMap = new HashMap<String, LocatorInfo>();
        try {
            List<PageInfo> list= uiDao.getPageInfos();
            if(list!=null|| list.size()>0){
                for (PageInfo pageInfo:list){
                    List<LocatorInfo> locatorInfos=  uiDao.getLocatorInfo(pageInfo.getpId());
                    for (LocatorInfo locatorInfo:locatorInfos){
                        locatorMap.put(locatorInfo.getlName(),locatorInfo);
                    }
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    @Test
    public void testPageAuto() throws Exception {
       // PageObjectAutoCode.autoCode();
        LoginPage  loginPage = new LoginPage();
        LocatorInfo locator=loginPage.getLocator("密码输入框");
        System.out.println(gson.toJson(locator));
    }

}
