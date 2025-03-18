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
		1. action		: jsp009_result.jsp
		2. method		: 주소표시창에 노출 x
		3. 입력 보관이름 	: kor / eng / math
		4. 합격여부		: 평균 60점 이상/ 과목 40점 이상
		5. 레벨 		: 90점 이상 A
					  80점 이상 B
					  70점 이상 C
					  나머지    D
					  [다시]
		</pre>
		<h2>SCORE</h2>
		
		<form action="jsp009_result.jsp" method="post">
		  <div class="my-3">
		    <label for="kor" class="form-label">국어: </label>
		    <input type="number" class="form-control" id="kor" name="kor" min="0" max="100">
		  </div> <!-- E kor -->
		   <div class="my-3">
		    <label for="eng" class="form-label">영어: </label>
		    <input type="number" class="form-control" id="eng" name="eng" min="0" max="100">
		  </div> <!-- E eng -->
		  <div class="my-3">
		  <label for="math" class="form-label">수학: </label>
		  <input type="number" class="form-control" id="math" name="math" min="0" max="100" >
		  </div> <!-- E math -->
		  <div class="my-3" style = "text-align:right" >
		  <button type="submit" title ="성적확인하기" class="btn btn-success">입력하기</button>
		  </div>
		</form>
	</div>
</body>
</html>