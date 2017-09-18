package org.yumin.zengDaWebUI.utils;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.dom4j.DocumentException;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.yumin.zengDaWebUI.dao.impl.UiDaoImpl;
import org.yumin.zengDaWebUI.entries.Locator;
import org.yumin.zengDaWebUI.entries.LocatorInfo;
import org.yumin.zengDaWebUI.entries.Log;
import org.yumin.zengDaWebUI.entries.PageInfo;
//包含导入了自定义的ByType枚举类型

/**
 * xml读取工具类
 * @author Administrator 刘正涛
 *
 */
public class PageObjectReadUtil {
	private static UiDaoImpl uiDao = new UiDaoImpl();
	//获取定位方式
	public static HashMap<String, LocatorInfo> readPageObjectInfo() {
		Log log=new Log(PageObjectReadUtil.class);
		HashMap<String, LocatorInfo> locatorMap = new HashMap<String, LocatorInfo>();
		locatorMap.clear();
		try {
			List<PageInfo> list= uiDao.getPageInfos();
			if(list!=null|| list.size()>0){
				for (PageInfo pageInfo:list){
					List<LocatorInfo> locatorInfos=  uiDao.getLocatorInfo(pageInfo.getpId());
					if(locatorInfos.size()>0 && locatorInfos!=null){
						for (LocatorInfo locatorInfo:locatorInfos){
							locatorMap.put(locatorInfo.getlName(),locatorInfo);
						}
					}else{
						log.error("页面对象无控件属性");
						locatorMap=null;
					}

				}

			}else {
				log.error("无任何页面对象");
				locatorMap=null;
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		return locatorMap;
	}
	/**
	 * @param type
	 */
	public static Locator.ByType getByType(String type) {
		Locator.ByType byType = Locator.ByType.xpath;
		if (type == null || type.equalsIgnoreCase("xpath")) {
			byType = Locator.ByType.xpath;
		} else if (type.equalsIgnoreCase("id")) {
			byType = Locator.ByType.id;
		} else if (type.equalsIgnoreCase("linkText")) {
			byType = Locator.ByType.linkText;
		} else if (type.equalsIgnoreCase("name")) {
			byType = Locator.ByType.name;
		} else if (type.equalsIgnoreCase("className")) {
			byType = Locator.ByType.className;
		} else if (type.equalsIgnoreCase("cssSelector")) {
			byType = Locator.ByType.cssSelector;
		} else if (type.equalsIgnoreCase("partialLinkText")) {
			byType = Locator.ByType.partialLinkText;
		} else if (type.equalsIgnoreCase("tagName")) {
			byType = Locator.ByType.tagName;
		}
		return byType;
	}

	public static List<PageInfo> getPageInfos(){
		return uiDao.getPageInfos();
	}
    //将字符串name 转化为首字母大写
	public static List<LocatorInfo> getLocatorInfo(Integer pId){
		return uiDao.getLocatorInfo(pId);
	}
	public static String captureName(String name) {
		char[] cs=name.toCharArray();
		cs[0]-=32;
		return String.valueOf(cs);
	}

	public static String getPageURL(String pageName)
	{
		pageName=captureName(pageName.toLowerCase());
		//System.out.print(pageName);
		PageInfo pageInfo=null;
		String URL=null;
		try {
			pageInfo=uiDao.getPageInfoByObjectName(pageName);
			if(pageInfo!=null){
				URL = pageInfo.getpValue();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}


		return URL;

	}
	public static  String getTestngParametersValue(String path,String ParametersName) throws DocumentException, IOException
	{
		File file = new File(path);
		if (!file.exists()) {
			throw new IOException("Can't find " + path);

		}
		String value=null;
		SAXReader reader = new SAXReader();
		Document  document = reader.read(file);
		Element root = document.getRootElement();
		for (Iterator<?> i = root.elementIterator(); i.hasNext();)
		{
			Element page = (Element) i.next();
			if(page.attributeCount()>0)
			{
				if (page.attribute(0).getValue().equalsIgnoreCase(ParametersName))
				{
					value=page.attribute(1).getValue();
					//System.out.println(page.attribute(1).getValue());
				}
				continue;
			}
			//continue;
		}
		return value;

	}

}
