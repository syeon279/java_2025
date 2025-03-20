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
	 	<div class="p-2 bg-dark text-white">
	    <h1>Bank</h1> 
	    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit </p>
		</div>
	</div>
	<div>
		<%
			String id = request.getParameter("id");
			String pass = request.getParameter("pass");
		%>
		<div class = "contanier my-5 p-5" >
			<table class="table table-striped my-5" >
			<caption style="text-align:center">유저 정보</caption>
				<tr>
					<th>ID</th>
					<td><%= id %></td>
				</tr>
				<tr>
					<th>Pass</th>
					<td><%= pass %></td>
				</tr>
				<tr>
					<th>잔액</th>
					<td></td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>