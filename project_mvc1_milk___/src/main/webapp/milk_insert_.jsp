<%@ page import="java.net.InetAddress"%>
<%@ page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	// 1. utf-8 설정
	request.setCharacterEncoding("UTF-8");

	// 2. 데이터 받기
	String name = request.getParameter("name_insert");
	int num = Integer.parseInt(request.getParameter("num_insert"));
	
	Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
	String url = "jdbc:mysql://localhost:3306/mybase";
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
		String sql_first = "select max(ono) `max` from milk_order_; ";
		String sql = "insert into milk_order (ono, oname, onum, oip) values (?, ?, ?, ?); ";
		
		int max = 0;
		pstmt = conn.prepareStatement(sql_first);
		rset = pstmt.executeQuery();
		if(rset.next()){
			max = rset.getInt("max") + 1;
		}
		
		rset.close();
		pstmt.close();
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, max);
		pstmt.setString(2, name);
		pstmt.setInt(3, num);
		pstmt.setString(4, InetAddress.getLocalHost().getHostAddress());
		
		// 6. 결과값 받아서 처리
		int result = pstmt.executeUpdate();
		if (result >0 ) {
			again = false;
			out.println("<script>alert('주문 성공! 주문 번호는 " + max +" 번 입니다.'); location.href='milk_main.jsp'; </script>");
		}  else {
			out.println("<script>alert('관리자에게 문의바랍니다.'); location.href='milk_main.jsp'; </script>");
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