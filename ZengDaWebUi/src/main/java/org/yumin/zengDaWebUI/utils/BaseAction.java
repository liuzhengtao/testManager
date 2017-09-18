package org.yumin.zengDaWebUI.utils;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.yumin.zengDaWebUI.entries.Locator;
import org.yumin.zengDaWebUI.entries.LocatorInfo;
import org.yumin.zengDaWebUI.entries.Log;

/**
 *
 */
public class BaseAction extends TestBaseCase{

	//protected 只在本包之内有权限，可访问
	//protected  WebDriver driver;
	// protected Log log;
	//定位信息图（对象库存储结构）
	protected HashMap<String,LocatorInfo>  locatorMap;
	Log log=new Log(this.getClass());

	/**
	 * 构造方法，创建创建BasePageOpera对象时，需要初始化的信息.传递相关参数
	 * this.getClass().getCanonicalName() 获取page类路径，也就是xml文档中的pageName
	 * @throws Exception
	 */
	public  BaseAction()
	{


	}
	public void getLocatorMap()
	{
		try {
				locatorMap = PageObjectReadUtil.readPageObjectInfo();
		} catch (Exception e) {
			log.error("getLocatorMap:"+e.getMessage());
			e.printStackTrace();
		}
	}
	static By getBy (Locator.ByType byType, LocatorInfo locator)
	{
		switch(byType)
		{
			case id:
				return By.id(locator.getlValue());
			case cssSelector:
				return By.cssSelector(locator.getlValue());
			case name:
				return By.name(locator.getlValue());
			case xpath:
				return By.xpath(locator.getlValue());
			case className:
				return By.className(locator.getlValue());
			case tagName:
				return By.tagName(locator.getlValue());
			case linkText:
				return By.linkText(locator.getlValue());
			case partialLinkText:
				return By.partialLinkText(locator.getlValue());
			//return null也可以放到switch外面
			default:
				return null;
		}


	}

	/**
	 * 从对象库获取定位信息
	 * @param locatorName 对象库名字
	 * @return
	 * @throws IOException
	 */
	public  LocatorInfo getLocator(String locatorName)
	{
		LocatorInfo locator;
		/**
		 * 在对象库通过对象名字查找定位信息
		 */
		locator=locatorMap.get(locatorName);
		/**
		 * 加入对象库，找不到该定位信息，就创建一个定位信息
		 */
		if(locator==null)
		{
			log.error("没有找到"+locatorName+"页面元素");
		}
		return locator;

	}

	public String getPageURL()
	{
		String pageURL=null;
		try {
			pageURL= PageObjectReadUtil.getPageURL(this.getClass().getCanonicalName());
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return pageURL;
	}

	/**
	 * 打开浏览器
	 * @param url
	 */
	public void open(String url)
	{
		driver.navigate().to(url);
		log.info("打开浏览器，访问"+url+"网址!");

	}
	/***
	 * 关闭浏览器窗口
	 */
	public void close()
	{
		driver.close();
		log.info("关闭浏览器窗口");
	}
	/**
	 * 退出浏览器
	 */
	public void quit()
	{
		driver.quit();
		log.info("退出浏览器");
	}
	/**
	 * 浏览器前进
	 */
	public void forward()
	{
		driver.navigate().forward();
		log.info("浏览器前进");
	}
	/**
	 * 浏览器后退
	 */
	public void back()
	{
		driver.navigate().back();
		log.info("浏览器后退");
	}
	/**
	 * 刷新浏览器
	 */
	public void refresh()
	{
		driver.navigate().refresh();
		log.info("浏览器刷新");
	}
	public WebElement findElement( final LocatorInfo locator) throws IOException
	{
		/**
		 * 查找某个元素等待几秒
		 */
		Waitformax(locator.getlTimeOut());
		WebElement webElement;
		webElement=getElement(locator);
		return webElement;


	}
	public void Waitformax(Integer t)
	{

		driver.manage().timeouts().implicitlyWait(t,TimeUnit.SECONDS);
	}
	/**
	 * 通过定位信息获取元素
	 * @param locator
	 * @return
	 * @throws NoSuchElementException
	 */
	public WebElement getElement(LocatorInfo locator)
	{
		/**
		 * locator.getElement(),获取对象库对象定位信息
		 */
		//locator=getLocator(locatorMap.get(key));
		WebElement webElement;
		switch (locator.getlType())
		{
			case "xpath" :
				//log.info("find element By xpath");
				webElement=driver.findElement(By.xpath(locator.getlValue()));
				/**
				 * 出现找不到元素的时候，记录日志文件
				 */
				break;
			case "id":
				//log.info("find element By xpath");
				webElement=driver.findElement(By.id(locator.getlValue()));
				break;
			case "cssSelector":
				//log.info("find element By cssSelector");
				webElement=driver.findElement(By.cssSelector(locator.getlValue()));
				break;
			case "name":
				//log.info("find element By name");
				webElement=driver.findElement(By.name(locator.getlValue()));
				break;
			case "className":
				//log.info("find element By className");
				webElement=driver.findElement(By.className(locator.getlValue()));
				break;
			case "linkText":
				//log.info("find element By linkText");
				webElement=driver.findElement(By.linkText(locator.getlValue()));
				break;
			case "partialLinkText":
				//log.info("find element By partialLinkText");
				webElement=driver.findElement(By.partialLinkText(locator.getlValue()));
				break;
			case "tagName":
				//log.info("find element By tagName");
				webElement=driver.findElement(By.partialLinkText(locator.getlValue()));
				break;
			default :
				//log.info("find element By xpath");
				webElement=driver.findElement(By.xpath(locator.getlValue()));
				break;

		}
		return webElement;
	}


}
