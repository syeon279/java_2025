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
		<pre>
		1. action		: jsp007_result.jsp
		2. method		: get
		3. 입력 보관이름 	: para 
		</pre>
		<form action="jsp007_result.jsp" method="get">
		  <div class="mb-3 mt-3">
		    <label for="query" class="form-label">검색어: </label>
		    <input type="text" class="form-control" id="query" name="para">
		  </div>
		  <button type="submit" class="btn btn-danger">submit</button>
		</form>
	</div>
</body>
</html>