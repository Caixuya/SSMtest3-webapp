package com.thxy.datasource;

import java.io.IOException;
import java.io.InputStream;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DataConnection {

	private String resource="mybatis-config.xml";
	private SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession;
	
	public SqlSession getSqlSession() throws IOException{
//这个java文件的全部代码也可以写成下面注释掉的三句，一样的意思		
//		InputStream inputStream=Resources.getResourceAsStream("SqlMapConfig.xml");
//		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
//		SqlSession sqlSession=sqlSessionFactory.openSession();
		
//		获取sqlMapConfig.xml文件流		
		InputStream inputStream=Resources.getResourceAsStream(resource);
		
		//创建工厂添加sqlMapConfig.xml
		sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		
		//获得session
		sqlSession=sqlSessionFactory.openSession();
		
		return sqlSession;
	}
}
