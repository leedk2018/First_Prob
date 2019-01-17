<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
</head>
<body>
<%-- <%
	request.setAttribute("error_msg", "错误");
%> --%>
	<h1>用户登录</h1>
	<form action="${pageContext.request.contextPath }/LoginServlet" method="post">
		账号:<input type="text" name="name" id="name" placeholder="您的姓名(账号)">
		<br>
		密码:<input type="password" name="password" id="password" placeholder="请输入密码">
		<br>
		<span style="color: red;">
			${requestScope.error_msg }
		</span>
		<br>
		<input type="reset" value="重置">
		<input type="submit" value="登录">
	</form>
	
</body>
</html>