<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.setMaxInactiveInterval(10*60); // 10 분 동안 
	session.setAttribute("username", "Dan");
	session.setAttribute("userage", "5");
	
	response.sendRedirect("jsp021_session1.jsp");
	
	



%>