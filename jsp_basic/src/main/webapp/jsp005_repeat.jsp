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
		<h3 class="card-header">Google search</h3>
		<form action="https://www.google.com/search" method="get">
		  <div class="mb-3 mt-3">
		    <label for="q" class="form-label">검색어: </label>
		    <input type="text" class="form-control" id="q" placeholder="구글에게 물어봐" name="q">
		  </div>
		  <button type="submit" class="btn btn-danger">Submit</button>
		</form>
	</div>
</body>
</html>