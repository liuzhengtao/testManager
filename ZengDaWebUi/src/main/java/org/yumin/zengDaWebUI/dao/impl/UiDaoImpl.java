package org.yumin.zengDaWebUI.dao.impl;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import  java.sql.*;
import java.util.ArrayList;
import java.util.List;


import com.google.gson.Gson;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.yumin.zengDaWebUI.dao.UiDao;
import org.yumin.zengDaWebUI.entries.LocatorInfo;
import org.yumin.zengDaWebUI.entries.PageInfo;
import org.yumin.zengDaWebUI.utils.Log;
public class UiDaoImpl implements UiDao {
	static Gson gson = new Gson();
	private Log log=new Log(this.getClass());
	private  SqlSession session = getSession();

	public  SqlSession getSession()
	{
		ApplicationContext factory=new ClassPathXmlApplicationContext("classpath:spring/spring-dao.xml");
		SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) factory.getBean("sqlSessionFactory");
		SqlSession session = sqlSessionFactory.openSession();
		return session;
	}
	

	@Override
	public PageInfo getPageInfoById(Integer pId) {
		SqlSession session = getSession();
		PageInfo pageInfo;
		try {
			 pageInfo = session.selectOne("getPageInfoById", pId);
		} finally {
			session.close();
		}
		return pageInfo;
	}

	@Override
	public PageInfo getPageInfoByObjectName(String pObjectName) {
		PageInfo pageInfo;
		try {
			pageInfo = getSession().selectOne("getPageInfoByName", pObjectName);
		} finally {
			session.close();
		}
		return pageInfo;
	}

	@Override
	public List<PageInfo> getPageInfos() {
		return null;
	}

	@Override
	public LocatorInfo getLocatorInfo(Integer lId) {
		return null;
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


