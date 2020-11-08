package com.aim.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;


import com.aim.dao.UserDao;
import com.aim.entity.User;
import com.aim.utils.DBUtils;

public class UserDaoImpl implements UserDao {

	@Override
	public boolean addUser(User user) {
		//数据库连接对象
		Connection conn = null;
		//sql预编译对象及执行对象
		PreparedStatement pstm = null;
		//添加成功标志
		boolean flag = true;
		try {
			conn = DBUtils.getConn();
			String sql = "insert into t_user values(seq_t_user.nextval,?,?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, user.getUserName());
			pstm.setString(2, user.getUserPassword());
			pstm.setString(3, user.getUserSex());
			pstm.setString(4, user.getUserPhone());
			//result代表数据库中有多少条数据发生了改变
			int result = pstm.executeUpdate();
			if(result == 0){
				flag = false;
			}
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		} finally{
			DBUtils.closeAll(null, pstm, conn);
		}
		return flag;			

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
	public boolean updateUser(User user) {
		return false;
	}

	@Override
	public boolean deleteUser(String userId) {
		return false;

	}

	@Override
	public User login(String userName, String userPassword) {
		//数据库连接对象
		Connection conn = null;
		//SQL预编译及执行对象
		PreparedStatement pstm = null;
		//sql查询结果集
		ResultSet rs = null;
		User user = null;
		try {
			conn = DBUtils.getConn();
			String sql = "select * from t_user where user_name = ? and user_password = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, userName);
			pstm.setString(2, userPassword);
			rs = pstm.executeQuery();
			if(rs.next()){
				user = new User();
				user.setUserId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setUserPassword(rs.getString(3));
				user.setUserSex(rs.getString(4));
				user.setUserPhone(rs.getString(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtils.closeAll(rs, pstm, conn);
		}
		
		return user;
	}

	
}
