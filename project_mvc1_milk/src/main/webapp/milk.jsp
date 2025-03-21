<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang ="ko">
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="mt-1">
	  <div class="p-3 text-white" style="background-color:#5B913B;">
	    <h1>MILK ORDER - PreparedStatement Ex</h1> 
	    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit </p>
	  </div>
	 </div>
	<!-- 메뉴판 -->
	<!-- 메뉴판 -->
	<div class="contanier card my-5" style="text-align:center; margin:60px">
		<h3 class="card-header bg-success text-light">MILK MENU</h3>
	  		<table class="table table-borderless my-5 table-hover" style="text-align:center">
	  		<caption style="text-align:center">메뉴판</caption>
			    <thead>
			      <tr>
			        <th scope = "col">NO</th>
			        <th scope = "col">NAME</th>
			        <th scope = "col">PRICE</th>
			      </tr>
			    </thead>
			    <tbody>
		<%
			Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
			String sql = "select * from milk_repeat";
			String url = "jdbc:mysql://localhost:3306/mbasic";
			String id = "root", pass = "1234";
		
			//2) jdbc 연동
			try {
				conn = DriverManager.getConnection(url, id, pass);
				pstmt = conn.prepareStatement(sql);
				
				rset = pstmt.executeQuery(); // select 표
				while(rset.next()){ // 줄
			//	out.println(rset.getInt("mno")+" / "+rset.getString("mname")+" / "+rset.getInt("mprice")+"<br/>"); // 칸 
				int mno = rset.getInt("mno");
				String mname = rset.getString("mname");
				int mprice = rset.getInt("mprice");
			%>
			<tr>
				<td><%= mno %></td>
				<td><%= mname %></td>
				<td><%= mprice %></td>
			</tr>			
			<%
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if(rset!=null){
					rset.close();
				}
				if(pstmt!=null){
					pstmt.close();
				}
				if(conn!=null){
					conn.close();
				}
			}
			%>		
			</tbody>
		</table>
	</div>
	
	<!-- 주문 현황 -->
	<!-- 주문 현황 -->
	<div class="contanier card my-5" style="text-align:center; margin:60px">
	<h3 class="contanier card-header p-3" style="background-color:#77B254;  color:white;" >MILK ORDER</h3>
		<table class="table table-borderless my-5 table-hover" style="text-align:center">
		<caption style = "text-align:center">milk 주문현황</caption>
		    <thead>
		      <tr>
		        <th scope = "col">NO</th>
		        <th scope = "col">NAME</th>
		        <th scope = "col">NUM</th>
		        <th scope = "col">주문 날짜</th>
		      </tr>
		    </thead>
		    <tbody>
			<%		
			try {
				// 드라이버 연동
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				// DB 연동
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mbasic", "root", "1234");
				
				// sql 처리 
				pstmt = conn.prepareStatement("select * from milk_order order by ono desc limit 1;");
				rset = pstmt.executeQuery(); // select 표
				while(rset.next()){ // 줄
				int no = rset.getInt("ono");
				String name = rset.getString("oname");
				int num = rset.getInt("onum");
				String date = rset.getString("odate");
			%>
			<tr>
				<td><%= no %></td>
				<td><%= name %></td>
				<td><%= num %></td>
				<td><%= date %></td>
			</tr>			
			<%
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if(rset!=null){
					rset.close();
				}
				if(pstmt!=null){
					pstmt.close();
				}
				if(conn!=null){
					conn.close();
				}
			}
			%>		
		    </tbody>
	  </table>
	</div>
	

	<div class="contanier card " style="text-align:center; margin:60px ">
		<h3 class="card-header bg-success text-white" style="color:black">MILK 주문하러가기</h3>
		<div id="accordion">
		<!-- 주문 하기 -->
		<!-- 주문 하기 -->
		  <div class="card">
		    <div class="card-header" style="background-color:#D99D81;">
		      <a class="btn" data-bs-toggle="collapse" href="#collapseOne" style="font-weight:bold">
		        주문하기
		      </a>
		    </div>
		    <div id="collapseOne" class="collapse show" data-bs-parent="#accordion">
		      <div class="card-body" style="background-color:rgb(255, 232, 182);" >
		        <form action="milk_insert_re.jsp" method="post" onsubmit="return milkOrder()">
				  <div class="mb-3 mt-3">
				    <label for="name" class="form-label">우유: </label>
				    <input type="text" class="form-control" id="name" placeholder="주문하실 우유를 적어주세요" name="name">
				  </div>
				  <div class="mb-3">
				    <label for="num" class="form-label">수량: </label>
				    <input type="number" class="form-control" id="num" placeholder="수량을 적어주세요" name="num" min=0>
				  </div>
				  <button type="submit" class="btn btn-success" >주문하기</button>
				</form>
		  <script>
		  	function milkOrder(){
		  		alter('주문을 확인해주세요.');
		  		let name = document.getElementById("name");
		  		let num = document.getElementById("num");
		  		if(name.value==""){
		  			alter('주문을 확인해주세요.'); name.focus(); return false;
		  		}
		  		
		  		if(num.value==""){
		  			alter('주문을 확인해주세요.'); num.focus(); return false;
		  		}
		  	}
		  </script>
		      </div> <!-- card-body -->
		    </div>
		  </div>
		<!-- 주문 수정 -->
		<!-- 주문 수정 -->
		  <div class="card">
		    <div class="card-header" style="background-color:#D99D81;">
		      <a class="collapsed btn" data-bs-toggle="collapse" href="#collapseTwo" style="font-weight:bold">
		        주문 수정
		      </a>
		    </div>
		    <div id="collapseTwo" class="collapse" data-bs-parent="#accordion">
		      <div class="card-body" style="background-color:rgb(255, 232, 182);" >
				<form action="milk_update.jsp" method="post" onsubmit="return milkUpdate()"  >
					<div class="mb-3 mt-3">
				    	<label for="no_update" class="form-label">주문 번호: </label>
				    	<input type="number" class="form-control" id="no_update" placeholder="주문 번호를 적어주세요" name="no_update" min=1>
				  	</div>
				  <div class="mb-3 mt-3">
				    <label for="name_update" class="form-label">우유: </label>
				    <input type="text" class="form-control" id="name_update" placeholder="수정하실 우유를 적어주세요" name="name_update">
				  </div>
				  <div class="mb-3">
				    <label for="num_update" class="form-label">수량: </label>
				    <input type="number" class="form-control" id="num_update" placeholder="수정하실 수량을 적어주세요" name="num_update" min=0>
				  </div>
				  <button type="submit" class="btn btn-success">수정하기</button>
				</form>
		  <script>
		  function milkUpdate(){
			let no = document.getElementById("no_update");
	  		let name = document.getElementById("name_update");
	  		let num = document.getElementById("num_update");
	  		if(no.value == ""){
	  			alter('주문을 확인해주세요.'); no.focus(); return false;
	  		}
	  		if(name.value == ""){
	  			alter('주문을 확인해주세요.'); name.focus(); return false;
	  		}
	  		
	  		if(num.value == ""){
	  			alter('주문을 확인해주세요.'); num.focus(); return false;
	  		}
		  }
		  </script>
		      </div>
		  </div>
		<!-- 주문 삭제 -->
		<!-- 주문 삭제 -->
		  <div class="card">
		    <div class="card-header" style="background-color:rgb(217, 157, 129);">
		      <a class="collapsed btn" data-bs-toggle="collapse" href="#collapseThree" style="font-weight:bold">
		        주문 삭제
		      </a>
		    </div>
		    <div id="collapseThree" class="collapse" data-bs-parent="#accordion">
		      <div class="card-body" style="background-color:rgb(255, 232, 182);">
		        <form action="milk_delete.jsp" method="post" onsubmit="return milkDelete()" >
		        	<div class="mb-3 mt-3">
				    	<label for="no_delete" class="form-label">주문 번호: </label>
				    	<input type="number" class="form-control" id="no_delete" placeholder="취소하실 주문 번호를 적어주세요" name="no_delete">
				  	</div>
				  <button type="submit" class="btn btn-success" >주문 취소하기</button>
				</form>
				<script>
			  	function milkDelete(){
			  		let no = document.getElementById("no_delete");
			  		if(no.value==""){
			  			alter('번호를 확인해주세요.'); no.focus(); return false;
			  		}
			  	}
				</script>
		      </div>
		    </div>
		  </div>
		</div>
	</div>
	</div> <!-- E 주문 -->
</body>
</html>