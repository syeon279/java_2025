<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- jsp025_my.jsp -->
<!-- jsp025_my.jsp -->
<%@ include file="jsp022_header.jsp" %>
<!--  nav -->
<!--  nav -->

	<div class = "contanier card m-5 p-5">
		<p class = "text-center" style = "font-size:3em"> 환영합니다!</p>
		<div>
			<table class = "table table-hover">
				<tr>
					<th>NAME</th>
					<td><%= session.getAttribute("userid") %></td>
				</tr>
				<tr>
					<th>PASS</th>
					<td><%= session.getAttribute("userpass") %></td>
				</tr>
			</table>
		</div>
	</div>
<!--  footer.jsp -->
<!--  footer.jsp -->
<%@ include file="jsp022_footer.jsp" %>