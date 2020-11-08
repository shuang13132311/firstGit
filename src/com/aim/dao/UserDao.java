package com.aim.dao;

import java.util.List;

import com.aim.entity.User;

public interface UserDao {
	
	//添加用户
	public boolean addUser(User user);
	
	//查询用户(byId)
	public User select(String userId);
	
	//查询所有用户
	public List<User> selectAllUser();
	
	//修改用户
	public boolean updateUser(User user);
	
	//删除用户
	public boolean deleteUser(String userId);
	
	//用户登陆
	public User login(String userName, String userPassword);
}
