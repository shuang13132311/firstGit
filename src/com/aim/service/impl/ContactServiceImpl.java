package com.aim.service.impl;

import java.util.List;

import com.aim.dao.ContactDao;
import com.aim.dao.impl.ContactDaoImpl;
import com.aim.entity.Contact;
import com.aim.service.ContactService;

public class ContactServiceImpl implements ContactService {
	
	
	//将DAO层对象注入到service层
	ContactDao contactDao = new ContactDaoImpl();
	
	@Override
	public boolean addContact(Contact contact) {
		boolean flag = contactDao.addContact(contact);
		return flag;
	}

	@Override
	public Contact selectContactById(int contactId) {
		Contact contact = contactDao.selectContactById(contactId);
		return contact;
	}

	@Override
	public List<Contact> seleceAllContactByUserId(int userId) {
		List<Contact> contactList = contactDao.seleceAllContactByUserId(userId);
		return contactList;
	}

	@Override
	public boolean updateContact(Contact contact) {
		Boolean flag = contactDao.updateContact(contact);
		return flag;
	}

	@Override
	public boolean deleteContactById(int contactId) {
		Boolean flag = contactDao.deleteContactById(contactId);
		return flag;
	}

	
}
