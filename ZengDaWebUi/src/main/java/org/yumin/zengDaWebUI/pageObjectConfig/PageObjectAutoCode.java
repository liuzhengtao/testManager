package org.yumin.zengDaWebUI.pageObjectConfig;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.yumin.zengDaWebUI.entries.LocatorInfo;
import org.yumin.zengDaWebUI.entries.PageInfo;
import org.yumin.zengDaWebUI.entries.Log;
import org.yumin.zengDaWebUI.utils.PageObjectReadUtil;

//通过解析xml文件自动生成对象库代码
public class PageObjectAutoCode {
	public Log log=new Log(this.getClass());
	public static void autoCode() throws Exception
	{
		List<PageInfo> pageInfos= PageObjectReadUtil.getPageInfos();
		//遍历页面对象信息组装页面对象
		for(PageInfo pageInfo:pageInfos)
		{

			//获取页面对象的名称
			String pageName=pageInfo.getpDesc();
			System.out.println(pageName);

			//获取page所属的类名
			String pageClassName=pageInfo.getpObjectName();
			//获取页面对象的包名
			String packageName=pageInfo.getpName();
			//--自动编写对象库代码（XXPage.java）开始--
			StringBuffer sb=new StringBuffer("package "+packageName+";\n");
			sb.append("import java.io.IOException;\n");
			sb.append("import java.io.InputStream;\n");
			sb.append("import org.yumin.zengDaWebUI.utils.BaseAction;\n");
			sb.append("import org.yumin.zengDaWebUI.entries.LocatorInfo;\n");
			sb.append("//"+pageName+"_对象库类\n");
			sb.append("public class "+ pageClassName+" extends BaseAction {\n");
			//sb.append("//用户打包成jar后查找对象库文件路径\n");
			//sb.append("private InputStream pathInputStream=PageObjectAutoCode.class.getClassLoader().getResourceAsStream(\"net/hk515/pageObjectConfig/UILibrary.xml\");	\n");
			sb.append(" public   "
					+ pageClassName
					+ "() {\n");
			sb.append("//工程内读取对象库文件\n	");
			sb.append("getLocatorMap();");
			sb.append("\n}");
			//sb.append("\n private String path=PageObjectAutoCode.class.getClassLoader().getResource(\"net/hk515/pageObjectConfig/UILibrary.xml\").getPath();");
			//遍历Page节点下的Locator节点
			List<LocatorInfo> locatorInfos= PageObjectReadUtil.getLocatorInfo(pageInfo.getpId());
			for(LocatorInfo locatorInfo:locatorInfos)
			{
				//获取locaror节点
				if(locatorInfo!=null){
					String locatorName=locatorInfo.getlName();

					sb.append("\n/***\n"
							+ "* "+locatorName+"\n"
							+ "* @return\n"
							+ "* @throws IOException\n"
							+ "*/\n");

					sb.append("public LocatorInfo "+locatorName+"() throws IOException\n {\n");
					//sb.append("   setXmlObjectPath(path);\n");
					sb.append("   LocatorInfo locator=getLocator(\""+locatorName+"\");\n");
					sb.append("   return locator;\n }\n");
				}

			}
			sb.append("}");
			//将自动生成的PageObject代码写入文件
			File pageObjectFile=new File("src/main/java/org/yumin/zengDaWebUI/pageObject/"+pageClassName+".java");
			if(pageObjectFile.exists())
			{
				pageObjectFile.delete();;
			}
			try {
				FileWriter fileWriter=new FileWriter(pageObjectFile, false);
				BufferedWriter output = new BufferedWriter(fileWriter);
				output.write(sb.toString());
				output.flush();
				output.close();
			} catch (IOException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
			System.out.println(sb);
			Log log=new Log(PageObjectAutoCode.class);
			log.info("自动生成对象库java代码成功");
		}


	}
	public static void main(String[] args) throws Exception {
		// TODO 自动生成的方法存根
		PageObjectAutoCode.autoCode();
	}

}
