package org.yumin.zengDaWebUI.pageObjectConfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetXmlPageObject {
	public  static void getXmlPageObject()
	{
		System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://172.16.230.149:8080/cfs-web-boss");
		String tString=driver.getPageSource();
		System.out.println(tString);
	}
	public static void main(String[] args)
	{
		// TODO 自动生成的方法存根
		GetXmlPageObject.getXmlPageObject();
	}

}
