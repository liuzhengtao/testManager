package org.yumin.zengDaWebUI.action;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;

import org.yumin.zengDaWebUI.pageObject.LoginPage;
import org.yumin.zengDaWebUI.utils.TestBaseCase;
import org.yumin.zengDaWebUI.utils.ElementAction;

public class CommonAction extends TestBaseCase {

	public static  void Login(String Url,String UserName,String PassWord) throws IOException
	{
		//此driver变量继承自TestBase变量
		LoginPage loginPage=new LoginPage();
		loginPage.open(Url);
		System.out.println(driver.getCurrentUrl());
		//设置截图名字
		ElementAction action=new ElementAction();
		action.clear(loginPage.密码输入框());
		action.type(loginPage.用户名输入框(),UserName);
		action.clear(loginPage.密码输入框());
		action.type(loginPage.密码输入框(),PassWord);
		action.click(loginPage.登录按钮());

	}
	public static void TimeWidgetManage(String elementName,String time) {
		String date=CommonAction.formatDate(time, "yyyy-MM-dd");
		String js="$(function(){$(\"input[name='"
				+ elementName
				+"']\""
				+ ").removeAttr('readonly');"
				+ "$(\"input[name='"
				+ elementName
				+"']\""
				+ ").val(\""
				+ date
				+ "\");"
				+ "})";
		((JavascriptExecutor) driver).executeScript(js);
		System.out.println(js);
	}
	public  static String formatDate(Date date,String format)
	{
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		System.out.println(formatter.format(date).toString());
		return formatter.format(date).toString();

	}
	public  static String formatDate(String date,String format)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat(format);
		String sss = null;
		try {
			sss = sdf2.format(sdf.parse(date));
			System.out.println(sss);
		} catch (ParseException e) {
			// TODO Auto-generated catch block  
			e.printStackTrace();
		}
		return sss;
	}
	public  static String formatDate(long date){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(formatter.format(date));
		return formatter.format(date);
	}

	public static void main(String[] args)
	{
		CommonAction.TimeWidgetManage("xngn", "2015-10-10");
		CommonAction.formatDate("89-09-19", "yyyy-MM-dd");
		CommonAction.formatDate(42369);
	}

}
