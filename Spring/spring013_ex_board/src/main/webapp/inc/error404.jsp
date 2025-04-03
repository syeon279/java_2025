<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage = "true" %>
<%  response.setStatus(200); %>   
    
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
	<div class = "contanier card m-5 p-5 alert alert-danger text-center">
		<h3> ERROR 404 </h3>
		<p class = "bg-white p-3"> <img src="images/error.png" alt="error"/> </p>
		<p class = "result"> 요청하신 페이지가 없습니다. 관리자에게 문의바랍니다.</p>
		<a href="<%= request.getContextPath()%>/" class= "btn btn-danger">HOME</a>
	</div>
</body>
</html>