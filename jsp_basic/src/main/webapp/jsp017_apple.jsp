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
	<div class = "contanier card m-5">
		<h3 class="card-header bg-warning "> 좋아하는 과일 정보 </h3>
		<div class = "card-body"> 
			<div>
				유저정보 : <%= request.getParameter("username")  %>
			</div>
			<img src="images/apple.jpg" alt="alpple">
		</div>
	</div>
</body>
</html>