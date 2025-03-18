<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang ="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class = "contanier card my-5">
		<h3 class="card-header"> MY </h3>
		<%
			String id = request.getParameter("email");
			String pass = request.getParameter("pass");
			String remember = request.getParameter("remember");
		%>
		<div style="font-size:2em">
		email : <%= id %> <br>
		password : <%= pass %> <br>
		remember : <%= remember!=null? "on" : "off" %> <br>
		</div>
		<a href="javascript:history.go(-1)" class = "btn btn-danger">BACK</a>
	</div>
</body>
</html>
<!-- jsp007_result.jsp -->