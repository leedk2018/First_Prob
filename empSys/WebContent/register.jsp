<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册</title>
</head>
<body>
	<h1>用户注册</h1>
	<form action="${pageContext.request.contextPath }/RegisterServlet" method="post">
		姓名:<input type="text" name="name" id="name" placeholder="即账号"><br>
		密码:<input type="password" name="password" id="password" placeholder="密码"><br>
		性别:<input type="radio" name="gender" value="男" checked="checked">男<input type="radio" name="gender" value="女">女<br>
		年龄:<input type="text" name="age" placeholder="请输入年龄"><br> 
		电话:<input type="text" name="phone" placeholder="请输入电话"><br>
		邮箱:<input type="text" name="email" placeholder="请输入邮箱">
		<br>
			${requestScope.error_msg }
		<br>
		<input type="reset" value="重置">
		<input type="submit" value="注册">
	</form>
</body>
</html>