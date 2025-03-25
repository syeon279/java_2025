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
	<div class = "contanier card m-5 p-5">
		<table>
			<tbody>
				<tr>
					<th scope="row">page</th>
					<td><%= pageContext.getAttribute("name") %></td>
				</tr>
				<tr >
					<th scope="row">request</th>
					<td><%= request.getAttribute("name") %></td>
				</tr>
				<tr>
					<th scope="row">session</th>
					<td><%= session.getAttribute("name") %></td>
				</tr>
				<tr>
					<th scope="row">application</th>
					<td><%= application.getAttribute("name") %></td>
				</tr>
			</tbody>
		</table>
		<p><%= request.getParameter("a") %></p>
		<p><a href="jsp018.jsp" class = "btn btn-danger">BACK</a></p>
	</div>
</body>
</html>