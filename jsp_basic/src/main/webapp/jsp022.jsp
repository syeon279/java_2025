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
	<nav class="navbar navbar-expand-sm bg-success navbar-dark">
	  <div class="container-fluid">
	    <ul class="navbar-nav">
	      <li class="nav-item">
	        <a class="nav-link active" href="#">LOGO</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="#">log in</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="#">log out</a>
	      </li>
	    </ul>
	  </div>
	</nav>
	<div class = "contanier card m-5 p-5">
		<div class="m-5 p-5 text-center">
			<%= session.getAttribute("username") %>
		</div>
		<div class = " p-5">
			<p style="text-align:center"><img src="images/login.png" alt = "login"></p>
		</div>
		
		<form action="jsp022_login_action.jsp" method="post" onsubmit="return form()">
		  <div class="my-3">
		    <label for="id" class="form-label">Email: </label>
		    <input type="text" class="form-control" id="id" name="id">
		  </div>
		   <div class="my-3">
		    <label for="pass" class="form-label">Password: </label>
		    <input type="password" class="form-control" id="pass" name="pass">
		  </div>
		  <div class="my-3">
		  <label for="remember" class="form-label"></label>
		  <input type="checkbox" name="remember"> remember
		  </div>
		  <div class="my-3">
		  <button type="submit" title ="로그인 하러가기" class="btn btn-danger">로그인</button>
		  </div>
		</form>
		<script>
			function form(){
				let id = document.querySelector("#id");
				let pass = document.querySelector("#pass");
				
				if(id.value == ""){
					alert('아이디를 입력해주세요'); id.focus(); return false;
				}
				if(pass.value == ""){
					alert('비밀번호를 입력해주세요'); pass.focus(); return false;
				}
			}
		</script>
	</div>
</body>
</html>
<!--  
      Q1. 아이디와 비밀번호 빈칸검사
      Q2. 처리경로 : jsp022_login_action.jsp  / 아이디와 비밀번호 데이터값 노출안됨.
      Q3. jsp022_login_action.jsp 
          - 데이터값 넘겨받기
          - 드라이버연동 / db연동 / sql처리 / 결과값 확인
          - 아이디와 비밀번호가 같은지 userinfo 에서 검색
          - 찾았으면 [경로안바뀌게] , 보이는 화면은 jsp022_login_my.jsp 페이지로 넘어가기 / 
            못찾았으면 정보를 확인해주세요~ 알림창띄우고 로그인페이지로 
          
         mysql> desc member;
         +-------+--------------+------+-----+---------+----------------+
         | Field | Type         | Null | Key | Default | Extra          |
         +-------+--------------+------+-----+---------+----------------+
         | no    | int          | NO   | PRI | NULL    | auto_increment |
         | name  | varchar(100) | NO   |     | NULL    |                |
         | pass  | varchar(50)  | NO   |     | NULL    |                |
         +-------+--------------+------+-----+---------+----------------+
         3 rows in set (0.00 sec)
         
         mysql> select * from member;
         +----+--------+------+
         | no | name   | pass |
         +----+--------+------+
         |  1 | first  | 11   |
         |  2 | second | 22   |
         |  3 | third  | 33   |
         |  4 | fourth | 44   |
         +----+--------+------+
         4 rows in set (0.00 sec)

 -->