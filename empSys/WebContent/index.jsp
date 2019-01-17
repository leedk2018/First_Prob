<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>员工管理系统</title>
<!-- <script type="text/javascript">
		function show_confirm() {
		var r = confirm("确定退出?");
		if (r == true) {
			document.getElenmentById("out").value="1";
			alert("退出成功!");
			return true;
		} else {
			document.getElenmentById("out").value="0";
			alert("不退出!");
			return false;
		}
	}
</script> -->
</head>
<body>
	<h1>超牛逼_员工管理系统</h1>
	<c:if test="${sessionScope.emp==null }">
		<a href="register.jsp">注册</a>
		<a href="login.jsp">登录</a>
	</c:if>
	<c:if test="${sessionScope.emp!=null }">
		<span>${sessionScope.emp.name }欢迎登录!</span>
		&emsp;&emsp;&emsp;
		<a href="${pageContext.request.contextPath }/EmpListServlet">查看员工列表</a>
		&emsp;
		<a href="${pageContext.request.contextPath }/LoginOut" >安全退出</a>
		&emsp;&emsp;&emsp;
		<span>上次登录时间:${sessionScope.lastTime }</span>
	</c:if>
 	
</body>
</html>