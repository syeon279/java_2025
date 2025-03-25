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
		<h3 class="card-header"> 쿠키값 삭제</h3>
		<%
			// 1. 쿠키값 있는지 확인
			String cookie = request.getHeader("Cookie");
		
			// 2. null 이 아니라면 시간을 0으로 설정
			if( cookie != null ){
				Cookie[] cookies = request.getCookies();
				for(Cookie c : cookies){
					c.setMaxAge(0);  // 쿠키의 유효기간 0으로 
					response.addCookie(c);
				}
			}
			// 3. 브라우저에 탑재하여 확인 
			response.sendRedirect("jsp020_cookie1.jsp");
		%>
		
	</div>
</body>
</html>