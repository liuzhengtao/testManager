package org.yumin.zengDaWebUI.action;

import org.yumin.zengDaWebUI.pageObject.LoginPage;
import org.yumin.zengDaWebUI.utils.ElementAction;
import org.yumin.zengDaWebUI.utils.TestBaseCase;

import java.io.IOException;

/**
 * Created by liuzhengtao on 2016/8/29 0029.
 */
public class LoginAction extends TestBaseCase {
    public LoginAction(String Url,String UserName,String PassWord) throws IOException
    {
        //此driver变量继承自TestBase变量
        LoginPage loginPage=new LoginPage();
        loginPage.open(Url);
        System.out.println(driver.getCurrentUrl());
        ElementAction action=new ElementAction();
        //action.click(loginPage.审核管理系统());
        action.sleep(1);
        action.clear(loginPage.密码输入框());
        action.type(loginPage.用户名输入框(),UserName);
        action.clear(loginPage.密码输入框());
        action.type(loginPage.密码输入框(),PassWord);
        action.submit(loginPage.登录按钮());
    }
}
