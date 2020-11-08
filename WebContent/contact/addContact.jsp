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
	<form action="${pageContext.request.contextPath}/ContactServlet?method=addContact" method="post">
		联系人姓名:		<input type="text" name="contactName"><br />
		请选择性别:		<input type="radio" name="contactSex" value="男">男
						<input type="radio" name="contactSex" value="女">女<br />
		请输入电话号码:	<input type="text" name="contactPhone">
						<input type="text" name="userId" value="${ user.userId}">
						<input type="submit" value="提交"> 
	</form>
</body>
</html>