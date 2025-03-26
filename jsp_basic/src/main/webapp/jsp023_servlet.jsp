<%@page import="jsp023_servlet.Servlet001"%>
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
		<h3 class="card-header"> 001. Servlet</h3>
		<pre class = "alert alert-success m-3">
		1. 					  .java
		2.	java thread 이용해서 동작
		3. mvc 패턴에서 controller 역할을 함 	/ Controller( servlet, java )
		</pre>
		
		<div class = "p-3">
		<h4> 1. java class 부품 객체 사용</h4>
		<%
			Servlet001 basic = new Servlet001(10, 20);
			out.println(basic.getA());
		%>
		</div>
		<div class = "p-3">
		<h4> 2. servlet get/post</h4>
		<pre>
		 예제) Servlet002
		 1. web.xml servlet controller 등록 - 배포관리
		 2. @WebServlet("/Servlet002") 테스트용
		 </pre>
		
		<%
			
		%>
		</div>
	</div>
</body>
</html>