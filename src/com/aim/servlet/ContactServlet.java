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
@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
	//将service层对象注入servlet
	ContactService contactService = new ContactServiceImpl();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String method = request.getParameter("method");
		if("addContact".equals(method)){
			addContact(request, response);
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
	
/*	protected void selectAllContact(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {				
		//获取userId
		HttpSession session = request.getSession(false);
		User user = (User)session.getAttribute("user");
		int userId = user.getUserId();
		List<Contact> contactList = contactService.seleceAllContactByUserId(userId);
		request.setAttribute("contactList", contactList);
		System.out.println("selectAllContact11111");
	}
*/
}
