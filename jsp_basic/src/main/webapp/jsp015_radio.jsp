<%@ page import="java.util.*"%>
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
		<h3 class="card-header bg-success " style = "text-align:center; color:white" > RADID - 단일선택 </h3>
		<% 
			String username = request.getParameter("usernameR");
			String optradio = request.getParameter("optradio");
		%>
		<table class = "table" style = "text-align:center"  >
			<caption style = "text-align:center"> radio 데이터 확인</caption>
			<tbody>
				<tr>
					<th scope="row">USER</th>
					<td><%= username %></td>
				</tr>
				<tr>
					<th scope="row">CHECK</th>
					<td><%= optradio %></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>