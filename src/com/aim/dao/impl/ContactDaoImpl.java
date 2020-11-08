package com.aim.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.aim.dao.ContactDao;
import com.aim.entity.Contact;
import com.aim.utils.DBUtils;

public class ContactDaoImpl implements ContactDao {

	@Override
	public boolean addContact(Contact contact) {
		Connection conn = null;
		PreparedStatement pstm = null;
		boolean flag = false;
		try {
			conn = DBUtils.getConn();
			String sql = "insert into t_contact values(seq_t_contact.nextval,?,?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, contact.getContactName());
			pstm.setString(2, contact.getContactSex());
			pstm.setString(3, contact.getContactPhone());
			pstm.setInt(4, contact.getUserId());
			int result = pstm.executeUpdate();
			if(result != 0){
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtils.closeAll(null, pstm, conn);
		}
		return flag;
	}

	@Override
	public Contact selectContactById(String contactId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contact> seleceAllContactByUserId(int userId) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Contact contact = null;
		List<Contact> list = new ArrayList<>();
		try {
			conn = DBUtils.getConn();
			String sql = "select * from t_contact where user_id = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, userId);
			rs = pstm.executeQuery();
			while(rs.next()){
				contact = new Contact();
				contact.setContactId(rs.getInt(1));
				contact.setContactName(rs.getString(2));
				contact.setContactSex(rs.getString(3));
				contact.setContactPhone(rs.getString(4));
				list.add(contact);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean updateContact() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteContact() {
		// TODO Auto-generated method stub
		return false;
	}

}
