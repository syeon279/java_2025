<%@ page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	// 1. utf-8 설정
	request.setCharacterEncoding("UTF-8");
	
	// 2. 데이터 받기
	int no = Integer.parseInt(request.getParameter("no_delete"));
	
	Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
	String url = "jdbc:mysql://localhost:3306/mbasic";
	String id = "root", pass = "1234";	
	try {
		// 3. 드라이버 로딩
		Class.forName("com.mysql.cj.jdbc.Driver");
		// 4. DB 연동
		conn = DriverManager.getConnection(url, id, pass);
	} catch (Exception e){
		e.printStackTrace();
	}
	
	try {
		
		boolean again = true;
		while(again){
			
		// 5. sql 처리
		String sql = "delete from milk_order where ono=?;";

		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, no);
		
		// 6. 결과값 받아서 처리
		int result = pstmt.executeUpdate();
		if (result >0 ) {
			again = false;
			out.println("<script>alert('주문 취소 성공!'); location.href='milk.jsp'; </script>");
		}  else {
			out.println("<script>alert('관리자에게 문의바랍니다.'); location.href='milk.jsp'; </script>");
		}
		
		} // E while
		
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		if(rset != null) {
			rset.close();
		}
		if(pstmt != null) {
			pstmt.close();
		}
		if(conn != null) {
			conn.close();
		}
	}

%>