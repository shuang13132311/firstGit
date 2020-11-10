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
	public Contact selectContactById(int contactId) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Contact contact = new Contact();
		try {
			conn = DBUtils.getConn();
			String sql = "select * from t_contact where contact_id = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, contactId);
			rs = pstm.executeQuery();
			if(rs.next()){
				contact.setContactId(rs.getInt(1));
				contact.setContactName(rs.getString(2));
				contact.setContactSex(rs.getString(3));
				contact.setContactPhone(rs.getString(4));
				contact.setUserId(rs.getInt(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return contact;
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
				contact.setUserId(rs.getInt(5));
				list.add(contact);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean updateContact(Contact contact) {
		Connection conn = null; 
		PreparedStatement pstm = null;
		Boolean flag = false;
		try {
			conn = DBUtils.getConn();
			String sql = "update t_contact set contact_name = ?,contact_sex = ?,contact_phone = ? where contact_id = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, contact.getContactName());
			pstm.setString(2, contact.getContactSex());
			pstm.setString(3, contact.getContactPhone());
			pstm.setInt(4, contact.getContactId());
			int result = pstm.executeUpdate();
			if(result != 0){
				//修改成功
				flag = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean deleteContactById(int contactId) {
		Connection conn = null;
		PreparedStatement pstm = null;
		Boolean flag = false;
		try {
			conn = DBUtils.getConn();
			String sql = "delete t_contact where contact_id = ? ";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, contactId);
			int result = pstm.executeUpdate();
			if(result != 0){
				//删除成功
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}

	

}
