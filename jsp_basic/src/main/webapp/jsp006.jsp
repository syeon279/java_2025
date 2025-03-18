
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
		<h3 class="card-header">[jsp 기본요소] 001. 주석</h3>
		<div class = "alert alert-warning">코드 설명글</div>
		<!-- HTML 주석  -->
		<%-- JSP 주석 --%>
		<% //JAVA 주석 %>
	</div>
	
	<div class="contanier card my-5">
		<h3 class = "card-header">[jsp 기본요소] 002. 페이지 지시자</h3>
		<%@page import="java.util.ArrayList"%>
		
		<h3 class = "card-header">[jsp 기본요소] 003. 스크립트립</h3>
		<div class = "alert alert-warning">자바코드 - ctrl + space bar</div>
		<%
			ArrayList<String> list = new ArrayList<>();
			list.add("one"); list.add("two"); list.add("three");
		%>
		
		<h3 class = "card-header">[jsp 기본요소] 004. 표현식 </h3>
		<%=list %>
		
		<h3 class = "card-header">[jsp 기본요소] 005. 선언 </h3>
		<%! int global = 0; public String company(){return "(주)The";} %>
		<% 
			int local=0; 
		%>
		<%= ++global%>
		<%= ++local%>
		<p>copyright &copy;<%=company() %> all rights reserved.</p>
		<!-- <%--<%= company()%--%>에 세미콜론 -->
	</div>
</body>
</html>
<!-- jsp006.jsp -->