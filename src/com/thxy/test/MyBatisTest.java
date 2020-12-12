package com.thxy.test;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.thxy.dao.user.UserMapper;
import com.thxy.datasource.DataConnection;
import com.thxy.pojo.User;

public class MyBatisTest {
	
	public DataConnection dataConn=new DataConnection();
	
	@Test
	public void count() throws IOException{
		SqlSession sqlSession=dataConn.getSqlSession();
		
		UserMapper mapper=sqlSession.getMapper(UserMapper.class);
		int count=mapper.count();
		System.out.println("查找到数据库中一共有数据"+count+"条");
		sqlSession.close();
		
		
	}
	
}
