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
	<div class="mt-1 ">
	  <div class="p-2 bg-dark text-light">
	    <h1>Bank</h1> 
	    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit </p>
	  </div>
	</div>
	<div class = "contanier p-5">
		<h3>계좌 확인하기</h3>
		<form action="Bank_result.jsp" method="post">
		  <div class="my-3">
		    <label for="id" class="form-label">ID: </label>
		    <input type="text" class="form-control" id="id" name="id">
		  </div> <!-- E id -->
		   <div class="my-3">
		    <label for="pass" class="form-label">Pass: </label>
		    <input type="text" class="form-control" id="pass" name="pass">
		  </div> <!-- E pass -->
		  <button type="submit" title ="계좌 확인하기" class="btn btn-primary">입력</button>
		  </div>
		</form>
	</div>
</body>
</html>