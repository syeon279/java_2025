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
		<h3 class="card-header"> MY SCORE </h3>
		<%
			int kor = Integer.parseInt(request.getParameter("kor"));
			int eng = Integer.parseInt(request.getParameter("eng"));
			int math = Integer.parseInt(request.getParameter("math")) ;
			int total= kor + eng + math; 
			double avg = total/3.0;
			String savg = String.format("%.2f", avg);
			String level = kor<40|| eng<40 || math<40? "[다시]" : avg<70? "D" : avg<80? "C" : avg<90? "B" : "A";
		%>
		  <table class="table table-bordered table-striped table-hover my-5">
		  <caption>성적표</caption>
		    <thead>
		      <tr>
		        <th scope ="col">국어</th>
		        <th scope ="col">영어</th>
		        <th scope ="col">수학</th>
		        <th scope ="col">총점</th>
		        <th scope ="col">평균</th>
		        <th scope ="col">레벨</th>
		      </tr>
		    </thead>
		    <tbody>
		 		<tr>
		 			<td><%= kor %></td>
		 			<td><%= eng %></td>
		 			<td><%= math %></td>
		 			<td><%= total %></td>
		 			<td><%= savg %></td>
		 			<td><%= level %></td>
		 		</tr>
		    </tbody>
		 </table>
		<a href="javascript:history.go(-1)" class = "btn btn-danger">BACK</a>
	</div>
</body>
</html>
<!-- jsp007_result.jsp -->