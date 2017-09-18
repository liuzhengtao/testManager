package org.yumin.zengDaWebUI.pageObject;
import java.io.IOException;
import java.io.InputStream;
import org.yumin.zengDaWebUI.utils.BaseAction;
import org.yumin.zengDaWebUI.entries.LocatorInfo;
//改造录单系统登录页面_对象库类
public class LoginPage extends BaseAction {
 public   LoginPage() {
//工程内读取对象库文件
	getLocatorMap();
}
/***
* 账户登录
* @return
* @throws IOException
*/
public LocatorInfo 账户登录() throws IOException
 {
   LocatorInfo locator=getLocator("账户登录");
   return locator;
 }

/***
* 用户名输入框
* @return
* @throws IOException
*/
public LocatorInfo 用户名输入框() throws IOException
 {
   LocatorInfo locator=getLocator("用户名输入框");
   return locator;
 }

/***
* 密码输入框
* @return
* @throws IOException
*/
public LocatorInfo 密码输入框() throws IOException
 {
   LocatorInfo locator=getLocator("密码输入框");
   return locator;
 }

/***
* 登录按钮
* @return
* @throws IOException
*/
public LocatorInfo 登录按钮() throws IOException
 {
   LocatorInfo locator=getLocator("登录按钮");
   return locator;
 }
}