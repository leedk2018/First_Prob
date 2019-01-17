<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<a href="javascript:doPost("/TestServlet", {"name":"张三"})">提交</a>

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

</body>
</html>