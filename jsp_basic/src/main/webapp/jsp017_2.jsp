<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	String username = request.getParameter("username");
	String fruit = request.getParameter("fruit");
	
	if(fruit.equals("apple")){ 
		request.getRequestDispatcher("jsp017_apple.jsp").forward(request, response);
	} else if (fruit.equals("banana")) {
		request.getRequestDispatcher("jsp017_banana.jsp").forward(request, response);
	} else if (fruit.equals("coconut")) {
		request.getRequestDispatcher("jsp017_coconut.jsp").forward(request, response);
	}
	
%>