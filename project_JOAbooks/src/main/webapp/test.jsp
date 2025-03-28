<%@page import="org.apache.commons.collections4.bag.SynchronizedSortedBag"%>
<%@page import="com.company.domain.BoardVo"%>
<%@page import="com.company.dao.BoardDao"%>
<%@page import="com.company.dbmanager.DBManager"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="inc/JOAbooks_header.jsp" %>
<!-- header -->
<!-- header -->

	<div class = "contanier card m-5">
		<h3 class="card-header"> TEST </h3>
	<p><a href = "no.jsp" class = "btn btn-danger"> NO PAGE </a></p>
	</div>
	<!-- E Div -->
	<!-- E Div -->
 	<div class = "contanier card m-5">
		<h3 class="card-header"> DBCP </h3>
 	<%
  			Connection conn = null;
 			DBManager db = new DBManager();
 			conn = db.getConnection();
 			
 			if(conn != null){
 			out.println("DBCP 연동 성공");
 			}  
 	%>
	</div>
	<!-- E Div -->	
	<!-- E Div -->
	<div class = "contanier card m-5">
		<h3 class="card-header"> MODEL </h3>
		<ol>
			<li> DB: table </li>
			<li> Dto : </li>
			<li> Dao : </li>
			<li> Test </li>
		</ol>
		<%
			
			BoardDao dao = new BoardDao();
			BoardVo vo = new BoardVo();
			
			
			
			/* vo.setBtitle("HI");
			vo.setBcontent("hello world");
			vo.setBname("소현");
			System.out.println( dao.insert(vo)); */
		
			
			//System.out.println(dao.delete(5));
			
			//vo.setBtitle("안녕");
			//vo.setBcontent("bye bye");
			//vo.setBno(4);
			//System.out.println(dao.update(vo));
			
			
			//System.out.println( dao.updateHit(4));
			
			// System.out.println(dao.select(4));
			//System.out.println( dao.selectAll() );
			
		%>
	</div>   
	<!-- E Div -->
	<!-- E Div -->
	<div class = "contanier card m-5">
		<h3 class="card-header"> VIEW </h3>
		<pre>
		[webapp]-[board]
				list.jsp
				write.jsp
				detail.jsp
				update.jsp
		</pre>
	</div>
<!--  footer -->
<!--  footer -->
<%@ include file="inc/JOAbooks_footer.jsp" %>