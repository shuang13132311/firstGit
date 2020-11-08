<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<!-- JS代码实现前端判断 -->
<script type="text/javascript">
	
	//封装了一个通过元素获取id值的方法
 	function $$(id){
		return document.getElementById(id).value;
	}	
	
	function passWordCheck(){
		var v1 = $$("p1");
		var v2 = $$("p2");
		if(v1 != v2){
			window.alert("两次输入的密码不一致！");
		}
		
	}
</script>

<body>
	<form action="UserServlet?method=register" method="post">
		请输入账户:		<input type="text" name="userName"><br />
		请输入密码:		<input type="password" name="userPassword" id="p1">
		请再次请输入密码:	<input type="password" id="p2"><br />
		请选择性别:		<input type="radio" name="userSex" value="男">男
						<input type="radio" name="userSex" value="女">女<br />
		请输入电话号码:	<input type="text" name="userPhone">
						<input type="submit" value="提交" onclick="passWordCheck()"> <!-- //提交按钮，并触发前台验证 -->
	</form>
</body>
</html>