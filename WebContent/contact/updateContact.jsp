<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
it is updateContact.jsp
	<form action="ContactServlet?method=updateContact" method="post">
		请输入联系人:		<input type="text" name="contactName" value="${contact.contactName }"><br />
		请选择性别:		<input type="radio" name="contactSex" value="男">男  <%--  <c:if test="${contact.contactSex == '男'}" checked = "checked"></c:if>  --%>
						<input type="radio" name="contactSex" value="女">女<br />   <%-- <c:if test="${contact.contactSex == '女'}" checked = "checked"></c:if>  --%>
		请输入电话号码:	<input type="text" name="contactPhone" value="${contact.contactPhone }">
						<input type="hidden" name="contactId" value="${contact.contactId }">
						<input type="hidden" name="userId" value="${contact.userId }">
						<input type="submit" value="提交"> <!-- //提交按钮-->
	</form>
</body>
</html>