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
import com.aim.service.UserService;
import com.aim.service.impl.ContactServiceImpl;
import com.aim.service.impl.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	//将service层对象注入servlet
	UserService userService = new UserServiceImpl();
	ContactService contactService = new ContactServiceImpl();
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("UTF-8");
		String method = request.getParameter("method");
		if("login".equals(method)){
			login(request, response);
		}else if("register".equals(method)){
			register(request, response);
		}
		
	}
	
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		System.out.println(userName);
		User user = userService.login(userName, userPassword);
		if(user != null){
			//将登陆用户信息存储到session
			HttpSession session = request.getSession();
			session.setAttribute("user", user); 
			
			//查询当前对象的所有联系人信息，并转发到index页面
			int userId = user.getUserId();
			List<Contact> contactList = contactService.seleceAllContactByUserId(userId);
			request.setAttribute("contactList", contactList);			
			
			request.getRequestDispatcher("/index.jsp").forward(request, response);	//路径地址不变,刷新会被提示是否重复提交表单,但可以保留request范围内的信息
			//response.sendRedirect(request.getContextPath()+"/index.jsp");    			//路径地址会变,刷新流畅,但request范围内的信息会消失
		}else {
			System.out.println("没有查询到user");
			//让浏览器弹出提示框，密码错误
		}

	}

	

	protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		String userSex = request.getParameter("userSex");
		String userPhone = request.getParameter("userPhone");
		
		User user = new User();
		user.setUserName(userName);
		user.setUserPassword(userPassword);
		user.setUserSex(userSex);
		user.setUserPhone(userPhone);
		
		userService = new UserServiceImpl();
		boolean flag = userService.addUser(user);
		if(flag == true){
			//注册成功
			response.sendRedirect(request.getContextPath()+"/login.jsp");    		//路径地址会变，刷新流畅
		}else {
			//登陆失败，让浏览器弹出提示框，用户名已被注册
			//
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
	}*/
}
