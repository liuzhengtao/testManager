package org.yumin.zengDaWebUI.dao.impl;
import java.util.List;


import com.google.gson.Gson;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.yumin.zengDaWebUI.dao.UiDao;
import org.yumin.zengDaWebUI.entries.LocatorInfo;
import org.yumin.zengDaWebUI.entries.PageInfo;
import org.yumin.zengDaWebUI.entries.Log;
public class UiDaoImpl implements UiDao {
	static Gson gson = new Gson();
	private Log log=new Log(this.getClass());
	private  SqlSession session =null;

	public  SqlSession getSession()
	{
		ApplicationContext factory=null;
		SqlSessionFactory sqlSessionFactory=null;
		try {
			factory =new ClassPathXmlApplicationContext("classpath:spring/spring-dao.xml");
			sqlSessionFactory = (SqlSessionFactory) factory.getBean("sqlSessionFactory");
			session =sqlSessionFactory.openSession();
		}catch (Exception e){
			log.error(e.getMessage());
			e.printStackTrace();
		}
		return session;
	}

	@Override
	public PageInfo getPageInfoById(Integer pId) {
		PageInfo pageInfo=null;
		try {
			 pageInfo = getSession().selectOne("getPageInfoById", pId);
		}catch (Exception e){
			log.error(e.getMessage());
			e.printStackTrace();
		} finally {
			session.close();
		}
		return pageInfo;
	}

	@Override
	public PageInfo getPageInfoByObjectName(String pObjectName) {
		PageInfo pageInfo=null;
		try {
			pageInfo = getSession().selectOne("getPageInfoByName", pObjectName);
		}catch (Exception e){
			log.error(e.getMessage());
			e.printStackTrace();
		}finally {
			session.close();
		}
		return pageInfo;
	}

	@Override
	public List<PageInfo> getPageInfos() {
		List<PageInfo> list=null;
		try {
			list = getSession().selectList("getPageInfos");
			log.info(gson.toJson(list));
		}catch (Exception e){
			log.error(e.getMessage());
		}finally {
			session.close();
		}
		return list;
	}

	@Override
	public List<LocatorInfo> getLocatorInfo(Integer pId) {
		List<LocatorInfo> locatorInfos=null;
		try {
		   locatorInfos = getSession().selectList("getLocatorInfo",pId);
		}catch (Exception e){
			log.error(e.getMessage());
			e.printStackTrace();
		}finally {
			session.close();
		}

		return locatorInfos;
	}

	@Override
	public List<LocatorInfo> getLocatorInfos() {
		return null;
	}


	public String getStatement(String sqlId) {
		String name = this.getClass().getName();
		StringBuffer sb = (new StringBuffer()).append(name).append(".").append(sqlId);
		return sb.toString();
	}
}


