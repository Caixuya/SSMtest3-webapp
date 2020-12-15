package com.thxy.test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
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
	
	@Test
	public void testGetUserList() throws IOException{
		SqlSession sqlSession=dataConn.getSqlSession();
		List<User> userList=new ArrayList<User>();
		try {
			Integer currentPageNo=0;
			Integer pageSize=3;
			userList=sqlSession.getMapper(UserMapper.class).getPageUsers(currentPageNo, pageSize);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		System.out.println("userlist.size--->"+userList.size());
		SimpleDateFormat sdFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	//	System.out.println(userList+"\n");
		for(User user:userList) {
			System.out.println("testGetUserList=======>id:"+user.getId()+
						 " and userCode:"+user.getUserCode()+
						 " and userName:"+user.getUserName()+
						 " and userPassword:"+user.getUserPassword()+
						 " and Gender:"+user.getGender()+
						 " and creationDate:"+sdFormat.format(user.getCreationDate())+
						 " and ModifyBy:"+user.getModifyBy()+
						 " and modifyDate:"+sdFormat.format(user.getModifyDate()));//没有日期转换
			
			
		}
	}
}
