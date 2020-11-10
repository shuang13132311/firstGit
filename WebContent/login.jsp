<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>mars_change</title>
</head>
<script type="text/javascript">
	function toRegister(){
		window.location.href="<%=request.getContextPath()%>/register.jsp";
	}

</script>
<body>
		<form action="${pageContext.request.contextPath}/UserServlet?method=login" method="post">
			用户名:	<input type="text" name="userName">
			密   码:	<input type="password" name="userPassword">
					<input type="submit" value="登陆"><br />
					<input type="button" value="没有账号?点击注册!" onclick="toRegister()">
		</form>
</body>
</html>
