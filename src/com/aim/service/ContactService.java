package com.aim.service;

import java.util.List;

import com.aim.entity.Contact;

public interface ContactService {
	public boolean addContact(Contact contact);
	
	public Contact selectContactById(String contactId);
	
	public List<Contact> seleceAllContactByUserId(int userId);
	
	public boolean updateContact();
	
	public boolean deleteContact();
	
}
