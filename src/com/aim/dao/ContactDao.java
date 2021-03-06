package com.aim.dao;

import java.util.List;

import com.aim.entity.Contact;

public interface ContactDao {
	
	public boolean addContact(Contact contact);
	
	public Contact selectContactById(int contactId);
	
	public List<Contact> seleceAllContactByUserId(int userId);
	
	public boolean updateContact(Contact contact);
	
	public boolean deleteContactById(int contactId);
	
}
