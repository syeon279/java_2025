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
		<h3 class="card-header bg-success text-white"> 세션 - 서버측에 저장되는 정보 </h3>
		<div class="card-body p-5 text-center ">
			<table class = "table table-hover text-center">
				<caption class = "text-center">SESSION</caption>
				<tbody>
			<%
				String username = (String)session.getAttribute("username"); // 부모타입 - 타입캐스팅 object
				String userage = (String)session.getAttribute("userage"); 
				out.println("<tr><td>"+username+"</td><td>"+userage+"</td></tr>");
			%>
				</tbody>
			</table>
	
			<div class="text-center p-5">
				<a href="jsp021_session2.jsp" class ="btn btn-success m-5">세션값 저장</a>
				<a href="jsp021_session3.jsp" class ="btn btn-success m-5">세션값 삭제</a>
				<a href="jsp021_session4.jsp" class ="btn btn-success m-5">세션값 초기화</a>
			</div>
		</div>
	</div>
</body>
</html>