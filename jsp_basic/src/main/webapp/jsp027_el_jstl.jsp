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
		<h3 class="card-header"> 001. el: Expression Language (표현식) </h3>
		<div class ="card-body">
			<p> <% out.println("hello"); %></p>
			<p> <%= "hello" %></p>
			<p> ${ "hello" }  ${ 3.14 } ${ 'A' } </p>
			<a href="jsp027_result.jsp?name=dan">PARAM</a>
			<hr/>
			<% 
				Servlet001 s = new Servlet001 (1,2);
				pageContext.setAttribute("s",s);
				request.setAttribute("ss",s);
			%>
			<p>객체.변수명 ${ s.a }</p>
			<p>${ ss.b }</p>
		</div>
	</div>
	<%@taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
	<div class = "contanier card m-5">
		<h3 class="card-header">002. jstl </h3>
		<pre class = "alert alert-success">
		 	-1.  반복문, 조건문 등의 기본구현
			-2.  사용법
			 1. http://jakarta.apache.org/
			 2. 왼쪽메뉴 :  Tablibs
			 3. Standard Taglib -  다운로드 - jakarta-taglibs-standard-1.1.1.zip
			 4. [WEB-INF]-[lib] - jstl.jar / standard.jar
			
			-3. jstl 라이브러리
			  core : 기본적인 기능제공
			  fmt  : format 형식
			  xml  : xml관련처리
			  sql  : sql관련처리
		</pre>
		<c:if test="${1<20}"> 1은 20보다 작다 </c:if>
		<%
			String [] movie = { "드래곤 길들이기", "알라딘", "삼체"};
			pageContext.setAttribute("movie", movie);
			
			for( String m : movie){
				out.println(m);
			}
		%>
		<br/>
 		<c:forEach items="${ movie }" var="m" varStatus="status">
 			${ status.index } - ${m} <br/>
		</c:forEach> 
	</div>
</body>
</html>