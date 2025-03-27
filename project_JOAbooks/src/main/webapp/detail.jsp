<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang ="ko">
<%@ include file="inc/JOAbooks_header.jsp" %>
<!-- header -->
<!-- header -->
	<div class = "contanier card m-5 p-3">
		<h3 class="card-header"><%= session.getAttribute("btitle") %></h3>
		<div class="card-body d-flex justify-content-around ">
			<p><%= session.getAttribute("bno") %></p>
			<p><%= session.getAttribute("bname") %></p>
			<p> <i class="bi bi-book-half m-1"></i> <%= session.getAttribute("bhit") %></p>
		</div>
		<div class="card-body text-center">
			<p><%= session.getAttribute("bcontent") %></p>
		</div>
		<div class = "d-flex justify-content-end m-3">
			<a href = "/write.jsp" class = "btn btn-success m-1">수정</a>
			<a href = "/write.jsp" class = "btn btn-success m-1">삭제</a>
			<a href = "/write.jsp" class = "btn btn-outline-success m-1">목록보기</a>
		</div>
	</div>
<!--  footer -->
<!--  footer -->
<%@ include file="inc/JOAbooks_footer.jsp" %>