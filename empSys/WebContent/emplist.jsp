<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>员工信息</title>
<style type="text/css">

#t{
	width: 900px;
	border-collapse:collapse;
}
</style>
<script type="text/javascript">
	function doPost(to, p) { // to:提交动作（action）,p:参数  

		var myForm = document.createElement("form");

		myForm.method = "post";

		myForm.action = to;

		for ( var i in p) {
			var myInput = document.createElement("input");

			myInput.setAttribute("name", i); // 为input对象设置name  

			myInput.setAttribute("value", p[i]); // 为input对象设置value  

			myForm.appendChild(myInput);

		}

		document.body.appendChild(myForm);

		myForm.submit();

		document.body.removeChild(myForm); // 提交后移除创建的form  

	}
</script>
</head>
<body>
	<c:if test="${sessionScope.emp==null }">
		<script type="text/javascript">
			alert("请登录后操作,确定进入登录页面!");
			window.location.href = "login.jsp";
		</script>
	</c:if>
	<form action="${pageContext.request.contextPath }/SearchServlet" method="post">
		id:<input type="text" name="eid" id="eid" placeholder="请输入员工id">
		年龄:<input type="text" name="eage" id="eage" placeholder="请输入完整两个年龄">~<input
			type="text" name="eage1" id="eage1" placeholder="请输入完整两个年龄"> 
		姓名:<input type="text" name="ename" id="ename">
		<input type="submit" value="查询">
	</form>
	<table id="t" border="1">
		<thead>
			<tr>
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

		<c:forEach items="${requestScope.listEmp }" var="l">
			<tr>
				<td>${l.id }</td>
				<td>${l.name }</td>
				<td>${l.password }</td>
				<td>${l.gender }</td>
				<td>${l.age }</td>
				<td>${l.hiredate }</td>
				<td>${l.salary }</td>
				<td>${l.phone }</td>
				<td>${l.email }</td>
				<td><a
					href="${pageContext.request.contextPath }/ModifyServlet?id=${l.id }">修改</a></td>
				<td><a
					href="${pageContext.request.contextPath }/DeleteServlet?id=${l.id }">删除</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="${pageContext.request.contextPath }/index.jsp">返回</a>&emsp;&emsp;&emsp;
	<a href="${pageContext.request.contextPath }/ShowDeleteServlet">查看删除员工列表</a>
</body>
</html>