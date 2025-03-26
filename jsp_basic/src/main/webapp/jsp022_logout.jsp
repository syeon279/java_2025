<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	// jsp022
	// 1. 세션 초기화 코드
	session.invalidate();
	
	// 2. login 페이지로 넘기기
	// >> 경로 바로 넘기기
	//out.println("<script> alert('로그아웃 합니다.'); location.href='jsp022.jsp'; </script>");
	
	//response.sendRedirect("jsp022.jsp"); // 알러트 창 안뜸. 
	//request.getRequestDispatcher("jsp022_my.jsp").forward(request, response);
	
	// 다른 점
	// getRequestDispatcher는 요청과 응답을 유지한채 서버 내부에서 페이지를 바꿔서 보여줌 -> 브라우저의 url이 바뀌지 않음!
	
	// ver-3. 새로고침 http-equiv='refresh'    content='초; url=경로 '
	out.println("<meta http-equiv='refresh' content='2; url=jsp022.jsp' />");
%>