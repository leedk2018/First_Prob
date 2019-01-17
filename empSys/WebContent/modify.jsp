<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改员工信息</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/ChangeServlet"
		method="post">
		<span>ID:(${requestScope.modifyEmp.id })&gt;</span><input type="text" name="id" id="id" value="${requestScope.modifyEmp.id }" readonly="readonly"><br> 
		<span>姓名:(${requestScope.modifyEmp.name })&gt;</span><input type="text" name="name" id="name" value="${requestScope.modifyEmp.name }"><br> 
		<span>密码:(${requestScope.modifyEmp.password })&gt;</span>
			<input type="password" name="password" id="password" value="${requestScope.modifyEmp.password }"><br>
		<span>性别:(${requestScope.modifyEmp.gender })&gt;</span><input type="radio"
			name="gender" value="男" checked="checked">男<input
			type="radio" name="gender" value="女">女<br> 
		<span>年龄:(${requestScope.modifyEmp.age })&gt;</span><input
			type="text" name="age" value="${requestScope.modifyEmp.age }"><br> 
		<span>入职日期:(${requestScope.modifyEmp.hiredate })&gt;</span> <input type="date" name="hiredate" value="${requestScope.modifyEmp.hiredate }"><br>
		<span>薪资:(${requestScope.modifyEmp.salary })&gt;</span><input type="text"
			name="salary" id="salary" value="${requestScope.modifyEmp.salary }"><br> 
		<span>电话:(${requestScope.modifyEmp.phone })&gt;</span><input
			type="text" name="phone" value="${requestScope.modifyEmp.phone }"><br> 
		<span>邮箱:(${requestScope.modifyEmp.email })&gt;</span><input
			type="text" name="email" value="${requestScope.modifyEmp.email }"><br> 
		<input type="reset"value="重置">&emsp;&emsp;&emsp;<input type="submit" value="修改">
	</form>
</body>
</html>