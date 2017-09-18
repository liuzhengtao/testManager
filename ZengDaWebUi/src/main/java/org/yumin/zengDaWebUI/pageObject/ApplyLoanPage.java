package org.yumin.zengDaWebUI.pageObject;
import java.io.IOException;
import java.io.InputStream;
import org.yumin.zengDaWebUI.utils.BaseAction;
import org.yumin.zengDaWebUI.entries.LocatorInfo;
//申请信息页面_对象库类
public class ApplyLoanPage extends BaseAction {
 public   ApplyLoanPage() {
//工程内读取对象库文件
	getLocatorMap();
}
/***
* 标题类
* @return
* @throws IOException
*/
public LocatorInfo 标题类() throws IOException
 {
   LocatorInfo locator=getLocator("标题类");
   return locator;
 }
}