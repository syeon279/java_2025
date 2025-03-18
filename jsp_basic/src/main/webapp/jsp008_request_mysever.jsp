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
		<h3 class="card-header">MY SEARCH</h3>
		<pre class="my-3">
		1. action		: jsp008_result.jsp
		2. method		: get
		3. 입력 보관이름 	: email, pass
		</pre>
		<p style="text-align:center"><img src="images/login.png" alt = "login"></p>
		
		<form action="jsp008_result.jsp" method="get">
		  <div class="my-3">
		    <label for="email" class="form-label">Email: </label>
		    <input type="email" class="form-control" id="email" name="email">
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
		  <button type="submit" title ="로그인 하러가기" class="btn btn-danger">submit</button>
		  </div>
		</form>
	</div>
</body>
</html>