<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang ="ko">
<%@ include file="inc/JOAbooks_header.jsp" %>
<!-- header -->
<!-- header -->
	<div class = "contanier card m-5 p-3">
		<h3 class="card-header">게시판</h3>
		<table class = "table table-header text-center">
			<caption class = "text-center">글 목록</caption>
			<tr>
				<td><i class="bi bi-balloon-heart m-1"></i>No</td>
				<td><i class="bi bi-brush m-1"></i>Title</td>
				<td><i class="bi bi-cast m-1"></i>Name</td>
				<td><i class="bi bi-calendar-event m-1"></i>Date</td>
				<td><i class="bi bi-book-half m-1"></i> Hit</td>
			</tr>
			<tr>
 				<td><%= session.getAttribute("bno") %></td>
				<td><%= session.getAttribute("btitle") %></td>
				<td><%= session.getAttribute("bname") %></td>
				<td><%= session.getAttribute("bdate") %></td>
				<td><%= session.getAttribute("bhit") %></td> 

			</tr>
			<tr>
 				<td><%= session.getAttribute("bno") %></td>
				<td><%= session.getAttribute("btitle") %></td>
				<td><%= session.getAttribute("bname") %></td>
				<td><%= session.getAttribute("bdate") %></td>
				<td><%= session.getAttribute("bhit") %></td> 

			</tr>
			<tr>
 				<td><%= session.getAttribute("bno") %></td>
				<td><%= session.getAttribute("btitle") %></td>
				<td><%= session.getAttribute("bname") %></td>
				<td><%= session.getAttribute("bdate") %></td>
				<td><%= session.getAttribute("bhit") %></td> 
			</tr>
			<tr>
 				<td><%= session.getAttribute("bno") %></td>
				<td><%= session.getAttribute("btitle") %></td>
				<td><%= session.getAttribute("bname") %></td>
				<td><%= session.getAttribute("bdate") %></td>
				<td><%= session.getAttribute("bhit") %></td> 
			</tr>
		</table>
		<div class = "d-flex justify-content-end m-3">
			<a href = "/write.jsp" class = "btn btn-success">글쓰기</a>
		</div>
	</div>
<!--  footer -->
<!--  footer -->
<%@ include file="inc/JOAbooks_footer.jsp" %>