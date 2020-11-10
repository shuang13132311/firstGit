package com.aim.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aim.entity.Contact;
import com.aim.entity.User;
import com.aim.service.ContactService;
import com.aim.service.impl.ContactServiceImpl;

/**
 * Servlet implementation class ContactServlet
 */
//@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
	//将service层对象注入servlet
	ContactService contactService = new ContactServiceImpl();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String method = request.getParameter("method");
		if("addContact".equals(method)){
			addContact(request, response);
		}else if("selectContactById".equals(method)){
			selectContactById(request, response);
		}else if("updateContact".equals(method)){
			updateContact(request, response);
		}else if("deleteContactById".equals(method)){
			deleteContactById(request, response);
		}
		
		
	}
	
	protected void addContact(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contactName = request.getParameter("contactName");
		String contactSex = request.getParameter("contactSex");
		String contactPhone = request.getParameter("contactPhone");
		String userId = request.getParameter("userId");
		int userIdNew = Integer.valueOf(userId);
		
		Contact contact = new Contact();
		contact.setContactName(contactName);
		contact.setContactSex(contactSex);
		contact.setContactPhone(contactPhone);
		contact.setUserId(userIdNew);
		
		boolean flag = contactService.addContact(contact);
		if(flag == true){
			//添加联系人成功，查询当前用户的所有联系人信息，并转发到前台
			List<Contact> contactList = contactService.seleceAllContactByUserId(userIdNew);
			request.setAttribute("contactList", contactList);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			
		}else{
			//添加联系人失败
			System.out.println("添加联系人失败!");
		}
	}
	
	protected void selectContactById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contactId = request.getParameter("contactId");
		int contactIdNew = Integer.valueOf(contactId);
		Contact contact = contactService.selectContactById(contactIdNew);
		if(contact != null){
			//查询到当前contact，将信息存到request中，并转发到修改contact界面
			System.out.println("查询到contact");
			request.setAttribute("contact", contact);
			request.getRequestDispatcher("contact/updateContact.jsp").forward(request, response);
		}else{
			//查询失败
		}
		
		
	}
	
	protected void updateContact(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contactId = request.getParameter("contactId");
		int contactIdNew = Integer.valueOf(contactId);
		String contactName = request.getParameter("contactName");
		String contactSex = request.getParameter("contactSex");
		String contactPhone = request.getParameter("contactPhone");
		String userId = request.getParameter("userId");
		int userIdNew = Integer.valueOf(userId);
		Contact contact = new Contact();
		contact.setContactId(contactIdNew);
		contact.setContactName(contactName);
		contact.setContactSex(contactSex);
		contact.setContactPhone(contactPhone);
		
		Boolean flag = contactService.updateContact(contact);
		if(flag == true){
			//修改成功
			System.out.println("修改成功");
			List<Contact> contactList = contactService.seleceAllContactByUserId(userIdNew);
			request.setAttribute("contactList", contactList);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		
	}
	
	protected void deleteContactById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contactId = request.getParameter("contactId");
		String userId = request.getParameter("userId");
		int userIdNew = Integer.valueOf(userId);
		int contactIdNew = Integer.valueOf(contactId);
		boolean flag = contactService.deleteContactById(contactIdNew);
		if(flag == true){
			//删除成功
			System.out.println("删除成功");
			List<Contact> contactList = contactService.seleceAllContactByUserId(userIdNew);
			request.setAttribute("contactList", contactList);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else{
			//查询失败
		}
		
		
	}
	
}
