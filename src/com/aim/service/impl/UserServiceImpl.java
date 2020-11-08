package com.aim.service.impl;

import java.util.List;

import com.aim.dao.UserDao;
import com.aim.dao.impl.UserDaoImpl;
import com.aim.entity.User;
import com.aim.service.UserService;

public class UserServiceImpl implements UserService {
	
	//将DAO层对象注入到service层
	UserDao userDao = new UserDaoImpl();
	
	@Override
	public boolean addUser(User user) {
		return userDao.addUser(user);
	}

	@Override
	public User select(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> selectAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(String userId) {
		// TODO Auto-generated method stub

	}

	@Override
	public User login(String userName, String userPassword) {
		
		return userDao.login(userName, userPassword);
	}

}
