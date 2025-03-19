<%@page import="java.sql.*"%>
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
	<div class = "contanier card my-5">
		<h3 class="card-header"> </h3>
		<pre>
		1) 드라이버 로딩 Class.forName
		2) DB 연동 DriverManager.getConnection(url, id, pass)
		3) Statement, PreparedStatement
		4) 결과 : ResultSet (select) / int (intsert, update, delete)
		</pre>
		<%
			Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
			String sql = "select * from userinfo where name=? and no=?";
			String url = "jdbc:mysql://localhost:3306/mbasic";
			String id = "root", pass = "1234";
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(url, id, pass);
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,"first"); // 1 ?의 번호 1부터 시작함
				pstmt.setInt(2, 1); // 2. 두번째 물음표
				
				// 표 - 줄 - 칸 
				rset = pstmt.executeQuery(); // 표
				while(rset.next()){  // 해당 데이터 가져오기 
					out.println(rset.getInt("no") + "/" + rset.getString("name")+"/"+rset.getInt("age")+"<br/>"); 
					out.print(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (conn != null) {
					conn.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (rset != null) {
					rset.close();
				}
			}
		
		%>
	</div>
</body>
</html>