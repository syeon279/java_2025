<%@page import="java.net.InetAddress"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  //1. utf-8 설정
	request.setCharacterEncoding("UTF-8");  
	//2. request.getParameter() 이용해서 데이터받기  
	String oname  = request.getParameter("name");
	int    onum   = Integer.parseInt( request.getParameter("num") );
	//out.println(oname +"/" + onum);

	Connection conn = null;  PreparedStatement pstmt = null;   ResultSet rset = null;
	try{
		//3. Driver 연동
		Class.forName("com.mysql.cj.jdbc.Driver");
		//4. DB 연동
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mbasic" , "root" , "1234");
		//out.println(  "db연동성공 " + conn );
		//5. PreparedStatement 이용해서 sql처리
	}catch(Exception e){e.printStackTrace(); }	

	try{
		boolean again=true;
		while(again){
			String sql0 = "select max(ono) `max` from milk_order";
			String sql  = "insert into  milk_order (ono, oname, onum, oip)  values (?  , ? , ?,  ?);  ";  //##1 
			int max=0; // 사용자가 여럿일 때 
			pstmt = conn.prepareStatement(sql0); 
			rset = pstmt.executeQuery();
			if(rset.next()){ max= rset.getInt("max") +1 ; }
	
			rset.close();
			pstmt.close();
				
			pstmt = conn.prepareStatement(sql);  //##2  //##2
			pstmt.setInt(1, max); 
			pstmt.setString(2, oname);  //  1, oname     -> 첫번째 물음표, 값
			pstmt.setInt(3, onum);  //                -> 둘번째 물음표, 값
			pstmt.setString(4, InetAddress.getLocalHost().getHostAddress());   // ip
			//6. 결과값 받아서 처리
			//           pstmt.executeQuery();    sql - select 
			int result = pstmt.executeUpdate();     // sql - INSERT, UPDATE or DELETE;  실행줄수
			//														  location.href=''  주소표시창줄경로바꾸기
			if(result>0){ 
				again=false;
				out.println( 
					"<script>alert('주문성공! 주문번호는 " + max + "번 입니다.'); location.href='milk.jsp'; </script>" ); 
					
			}
			 
		}
	}catch(Exception e){
		e.printStackTrace();
		}finally{
		  if(rset  != null){  
			  rset.close();
			  }
		  if(pstmt != null){  
			  pstmt.close();
			  }
		  if(conn  != null){  
			  conn.close();
			  }
	}
%>