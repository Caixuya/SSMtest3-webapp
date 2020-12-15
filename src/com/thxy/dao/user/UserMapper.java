package com.thxy.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.thxy.pojo.User;

public interface UserMapper {

	//接口
	public int count();
	
	public List<User> getPageUsers(@Param("from")Integer currentPageNo,
								  @Param("pageSize")Integer pageSize);
}
