<%@ page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 1. 데이터 값 넘겨받기
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	String url = "jdbc:mysql://localhost:3306/mbasic";
	Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
	//out.println( id + pass); test1
	
	 try {
		//2. 드라이버연동 / db연동 / sql처리 / 결과값 확인
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url, "root", "1234");
		/* 	if(conn != null){
			out.println("연동 성공");
		} */ //test2
		int result = -1;
		
		// 3. 아이디와 비밀번호가 같은지 userinfo 에서 검색
		String sql = "select count(*) `cnt` from member where name = ? and pass = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pass);
		rset = pstmt.executeQuery();
		// int result = pstmt.executeUpdate(); /// insert update delete 에서 사용
		if(rset.next()){
			result = rset.getInt("cnt");
		}
		
		// 4. 찾았으면 [경로안바뀌게] , 보이는 화면은 jsp022_login_my.jsp 페이지로 넘어가기 
		if(result > 0){
			//request.getRequestDispatcher("jsp022_my.jsp").forward(request, response);
			out.println("<script> location.href='jsp022_my.jsp'; </script>");
			session.setAttribute("username", id); 
			session.setAttribute("userpass", pass); 
			
			// 세션정보 유지하기
		} else {
			out.println("<script> alert('정보를 확인해 주세요'); location.href='jsp022.jsp'; </script>");
		}
		// 뒤로가기 : history.go(-1);
	} catch (Exception e) {
		e.printStackTrace();
	} finally {

		if (pstmt != null) {
			pstmt.close();
		}
		if (conn != null) {
			conn.close();
		}
	}

%>
<!-- 
Q3. jsp022_login_action.jsp 
          - 데이터값 넘겨받기
          - 드라이버연동 / db연동 / sql처리 / 결과값 확인
          - 아이디와 비밀번호가 같은지 member 에서 검색
          - 찾았으면 [경로안바뀌게] , 보이는 화면은 jsp022_login_my.jsp 페이지로 넘어가기 / 
            못찾았으면 정보를 확인해주세요~ 알림창띄우고 로그인페이지로  -->