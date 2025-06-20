<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container card my-3 p-3">
		<h3 class="card-header my-1"> TEST 1 - SERVICE </h3>
		<div class="alert alrt-warning">${time}</div>
		
		<h3 class="card-header my-1">TEST2 -JSTL : if</h3>
		<c:if test="true">
			<div class="alert alert-warning">hi</div>
		</c:if>
		
		<h3 class="card-header my-1"> TEST3 - JSTL : forEach </h3>
		<table class="table table-striped tatble-bordered table-hover">
			<tbody>
				<tr>
					<c:forEach var="i" begin="1" end="3" >
					<td>${i}</td>
					</c:forEach>
				</tr>
			</tbody>
		</table>
	
	</div>

</body>
</html>