package org.yumin.zengDaWebUI.pageObject;
import java.io.IOException;
import java.io.InputStream;
import org.yumin.zengDaWebUI.utils.BaseAction;
import org.yumin.zengDaWebUI.utils.Locator;
//录单系统登录页面_对象库类
public class LoginPage extends BaseAction {
//用于eclipse工程内运行查找对象库文件路径
private String path="src/main/java/org/yumin/zengDaWebUI/pageObjectConfig/UILibrary.xml";
 public   LoginPage() {
//工程内读取对象库文件
	setXmlObjectPath(path);
getLocatorMap();
}
/***
* 审核管理系统
* @return
* @throws IOException
*/
public Locator 审核管理系统() throws IOException
 {
   Locator locator=getLocator("审核管理系统");
   return locator;
 }

/***
* 用户名
* @return
* @throws IOException
*/
public Locator 用户名输入框() throws IOException
 {
   Locator locator=getLocator("用户名输入框");
   return locator;
 }

/***
* 密码
* @return
* @throws IOException
*/
public Locator 密码输入框() throws IOException
 {
   Locator locator=getLocator("密码输入框");
   return locator;
 }

/***
* 登录
* @return
* @throws IOException
*/
public Locator 登录按钮() throws IOException
 {
   Locator locator=getLocator("登录按钮");
   return locator;
 }
}