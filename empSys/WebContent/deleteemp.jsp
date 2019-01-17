<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>删除的员工列表</title>
<style type="text/css">
	#t{
		width: 900px;
		border-collapse:collapse;
	}
</style>
</head>
<body>
	<c:if test="${sessionScope.emp==null }">
		<script type="text/javascript">
			alert("请登录后操作,确定进入登录页面!");
			window.location.href="login.jsp";
		</script>
	</c:if>
	<table border="1" id="t">
		<thead>
			<tr >
				<th>id</th>
				<th>姓名</th>
				<th>密码</th>
				<th>性别</th>
				<th>年龄</th>
				<th>入职日期</th>
				<th>薪资</th>
				<th>电话</th>
				<th>邮箱</th>
				<th colspan="2">操作</th>
			</tr>
		</thead>
		
		<c:forEach items="${requestScope.DeletelistEmp }" var="l">
			<tr >
				<td>${l.id }</td>
				<td>${l.name }</td>
				<td>${l.password }</td>
				<td>${l.gender }</td>
				<td>${l.age }</td>
				<td>${l.hiredate }</td>
				<td>${l.salary }</td>
				<td>${l.phone }</td>
				<td>${l.email }</td>
				<td><a href="${pageContext.request.contextPath }/EmptyServlet?id=${l.id }">清空</a></td>
				<td><a href="${pageContext.request.contextPath }/RecoveryServlet?id=${l.id }" >恢复</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="${pageContext.request.contextPath }/EmpListServlet">返回</a>
</body>
</html>