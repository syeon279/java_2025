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
	<div class = "contanier card m-5 p-3">
		<h3 class="card-header bg-success " style = "text-align:center; color:white" > Select - 단일선택 </h3>
		<% 
			String username = request.getParameter("usernameS");
			String color = request.getParameter("color");
		%>
		<table class = "table" style = "text-align:center"  >
			<caption style = "text-align:center"> color 확인</caption>
			<tbody>
				<tr>
					<th scope="row">USER</th>
					<td><%= username %></td>
				</tr>
				<tr>
					<th scope="row">CHECK</th>
					<td>
					<p class ="<%= color %> p-4 text-white"> 선택한 색상입니다. </p></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>
</html>