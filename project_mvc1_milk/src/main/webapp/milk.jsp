<%@ page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang = "ko">
<head>
	<meta charset="UTF-8">
	<title>MIlK</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="mt-3">
	  <div class="mt-4 p-5 " style = "background-color:#41644A; color:#F1F0E9">
	    <h1 style="font-weight:bolder;">Project MILK</h1> 
	    <p style = "font-style:italic">welcome!</p> 
	    <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Delectus, minus!</p>
	  </div>
	</div> 
	<!-- 메뉴판 -->
	<!-- 메뉴판 -->
	<div class="contanier card my-5" style = "text-align:center; padding: 20px; margin:60px;">
		<div class="card card-header" style = "background-color:#0D4715; color:#F1F0E9" >
		<h2>MENU</h2>
		</div>
		<div class="card card-body">
			<table class="table"  >
			<caption style = "text-align:center" >menu</caption>
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
						String url = "jdbc:mysql://localhost:3306/mbasic";
						String sql = "select * from milk_repeat";
						String id = "root", pass="1234";
						
						try {
							Class.forName("com.mysql.cj.jdbc.Driver");
							conn = DriverManager.getConnection(url, id, pass);
							pstmt = conn.prepareStatement(sql);
							
							rset = pstmt.executeQuery();
							while(rset.next()){
								int no = rset.getInt("mno");
								String name = rset.getString("mname");
								int price = rset.getInt("mprice");
						%>
					<tr>
						<td><%= no %></td>
						<td><%= name %></td>
						<td><%= price %></td>
					</tr>
					<% 
							}
						} catch (Exception e) {
							e.printStackTrace();
						} finally {
							if(rset != null){
								rset.close();
							}
							if(pstmt != null){
								pstmt.close();
							}
							if(conn != null){
								conn.close();
							}
						}
					
					%>
				</tbody>
			</table>
		</div>
	</div>
	<!-- 우유 주문 현황 -->
	<!-- 우유 주문 현황 -->
	<div class="contanier card my-5" style="text-align:center; margin:60px">
		<h3 class="contanier card-header p-3" style="background-color:#41644A;  color:#F1F0E9;" >MILK ORDER</h3>
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
					conn = DriverManager.getConnection(url, id, pass);
					
					// sql 처리 
					pstmt = conn.prepareStatement("select * from milk_order order by ono desc");
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
	<div class="contanier card my-5" style = "text-align:center; margin:60px;">
		<div id="accordion">
		  <div class="card">
		    <div class="card-header" style = "background-color:#0D4715;">
		      <a class="btn" data-bs-toggle="collapse" href="#collapseOne" style="color:#F1F0E9;">
		        우유 주문하기
		      </a>
		    </div>
		    <div id="collapseOne" class="collapse show" data-bs-parent="#accordion">
		      <div class="card-body" style = "padding-left: 50px; padding-right: 50px;">
				  <form action="milk_insert.jsp" method ="post" onsubmit="return milkOrder()">
					<div class="mb-3 mt-3">
					  <label for="name_insert" class="form-label">우유: </label>
					  <input type="text" class="form-control" id="name_insert" placeholder="주문하실 우유를 입력해주세요" name="name_insert">
					</div>
					<div class="mb-3">
					  <label for="num_insert" class="form-label">수량:</label>
					  <input type="number" class="form-control" id="num_insert" placeholder="우유의 수량을 입력해주세요" name="num_insert" min=0>
					</div>
					<button type="submit" class="btn" style = "background-color:#E9762B; color:#F1F0E9;">주문하기</button>
				  </form>
				  <script>
				  	function milkOrder(){
				  		let name = document.getElementById("name_insert");
				  		let num = document.getElementById("num_insert");
				  		if(name.value==""){
				  			alert('주문을 확인해주세요.'); name.focus(); return false;
				  		}
				  		
				  		if(num.value==""){
				  			alert('주문을 확인해주세요.'); num.focus(); return false;
				  		}
				  	}
				  </script>
		      </div>
		    </div>
		  </div>
		
		  <div class="card">
		    <div class="card-header" style = "background-color:#0D4715;">
		      <a class="collapsed btn" data-bs-toggle="collapse" href="#collapseTwo" style="color:#F1F0E9;">
		        주문 수정하기
		      </a>
		    </div>
		    <div id="collapseTwo" class="collapse" data-bs-parent="#accordion">
		      <div class="card-body" style = "padding-left: 50px; padding-right: 50px; ">
		         <form action="milk_update.jsp" method = "post" onsubmit="return milkUpdate()">
		         	<div class="mb-3">
					  <label for="no_update" class="form-label">주문 번호: </label>
					  <input type="number" class="form-control" id="no_update" placeholder="주문 번호를 입력해주세요" name="no_update" min=0>
					</div>
					<div class="mb-3 mt-3">
					  <label for="name_update" class="form-label">우유: </label>
					  <input type="text" class="form-control" id="name_update" placeholder="수정하실 우유를 입력해주세요" name="name_update">
					</div>
					<div class="mb-3">
					  <label for="num_update" class="form-label">수량: </label>
					  <input type="number" class="form-control" id="num_update" placeholder="수정하실 수량을 입력해주세요" name="num_update" min=0>
					</div>
					<button type="submit" class="btn" style = "background-color:#E9762B; color:#F1F0E9;">주문 수정하기</button>
				  </form>
				  <script>
				  	function milkUpdate(){
				  		let no = document.getElementById("no_update");
				  		let name = document.getElementById("name_update");
				  		let num = document.getElementById("num_update");
				  		if(no.value==""){
				  			alert('주문을 확인해주세요.'); no.focus(); return false;
				  		}
				  		if(name.value==""){
				  			alert('주문을 확인해주세요.'); name.focus(); return false;
				  		}
				  		
				  		if(num.value==""){
				  			alert('주문을 확인해주세요.'); num.focus(); return false;
				  		}
				  	}
				  </script>
		      </div>
		    </div>
	  </div>
  <div class="card">
    <div class="card-header" style = "background-color:#0D4715;" >
      <a class="collapsed btn" data-bs-toggle="collapse" href="#collapseThree" style="color:#F1F0E9;">
        주문 취소하기
      </a>
    </div>
    <div id="collapseThree" class="collapse" data-bs-parent="#accordion">
      <div class="card-body" style = "padding-left: 50px; padding-right: 50px;"> 
	     	<form action = "milk_delete.jsp" method = "post" onsubmit = "return milkDelete()">
		     <div class="mb-3">
			  <label for="no_delete" class="form-label">주문 번호: </label>
			  <input type="number" class="form-control" id="no_delete" placeholder="취소하실 주문 번호를 입력해주세요" name="no_delete" min=0>
			  </div>
			<button type="submit" class="btn" style = "background-color:#E9762B; color:#F1F0E9;">주문 취소하기</button>
	     	</form>
	     	<script>
	     		function milkDelete() {
	     			let no = document.getElementById("no_delete");
	     			if(no.value == ""){
	     				alert('주문번호를 확인해주세요.'); no.focus(); return false;
	     			}
	     		}
	     	</script>
      </div>
    </div>
  </div>
		</div>
	</div>
</body>
</html>