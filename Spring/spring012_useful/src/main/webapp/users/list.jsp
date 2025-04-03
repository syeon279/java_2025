<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="card contanier m-3 p-3">
		<h3 class="card-header bg-success text-white">Users</h3>
		<!--  for( UserDto u : list) {} -->
		<div class="card-body m-2">
			<table class=" table p-3 text-center">
				<caption class="text-center">Users</caption>
				<tr>
					<th>NO</th>
					<th>NAME</th>
					<th>AGE</th>
				</tr>
				<c:forEach var="u" items="${list}" varStatus="status">
					<tr>
						<td>${u.no}</td>
						<td><a href="detail.user?no=${ u.no }">${u.name}</a></td>
						<td>${u.age}</td>
						<td><a href="delete.user?no=${u.no }" class="btn btn-danger">삭제</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
		<!-- INSERT -->
	<!-- INSERT -->
	<div class="card contanier m-3 p-3">
		<form method="post" action="insert.user" id="userInsert"
			onsubmit="return form_update()">
			<fieldset>
				<legend class="card-header bg-success text-white mb-3">유저입력폼</legend>
				<div class="form-group p-3">
					<label for="name">이름</label> <input type="text" name="name"
						id="name" class="form-control" />
				</div>
				<div class="form-group p-3">
					<label for="age">나이</label> <input type="number" name="age"
						id="age" class="form-control" />
				</div>
				<div class="form-group p-3">
					<input type="submit" value="전송" class="btn  btn-danger" />
				</div>
			</fieldset>
			<script>
				function form_update() {

					let name = document.querySelector("#name");
					let age = document.querySelector("#age");

					if (name.value == "") {
						alert('빈 칸은 제출하실 수 없습니다.');
						name.focus();
						return false;
					}
					;
					if (age.value == "") {
						alert('빈 칸은 제출하실 수 없습니다.');
						age.focus();
						return false;
					}
					;
				}
			</script>
		</form>
	</div>
	<!-- UPDATE -->
	<!-- UPDATE -->
	<div class="card contanier m-3 p-3">
		<form method="post" action="update.user" id="userUpdate"
			onsubmit="return form()">
			<fieldset>
				<legend class="card-header bg-success text-white mb-3">유저
					수정폼</legend>
				<div class="form-group p-3">
					<label for="no_update">번호</label> <input type="text"
						name="no" id="no_update" class="form-control" />
				</div>
				<div class="form-group p-3">
					<label for="name_update">이름</label> <input type="text"
						name="name" id="name_update" class="form-control" />
				</div>
				<div class="form-group p-3">
					<label for="age_update">나이</label> <input type="number"
						name="age" id="age_update" class="form-control" />
				</div>
				<div class="form-group p-3">
					<input type="submit" value="전송" class="btn  btn-danger" />
				</div>
			</fieldset>
			<script>
				function form() {

					let name = document.querySelector("#name_update");
					let age = document.querySelector("#age_update");
					let no = document.querySelector("#no_update");

					if (name.value == "") {
						alert('빈 칸은 제출하실 수 없습니다.');
						name.focus();
						return false;
					}
					;
					if (age.value == "") {
						alert('빈 칸은 제출하실 수 없습니다.');
						age.focus();
						return false;
					}
					;
					if (no.value == "") {
						alert('빈 칸은 제출하실 수 없습니다.');
						no.focus();
						return false;
					}
					;
				}
			</script>
		</form>
	</div>
</body>
</html>
<!-- list.jsp -->
<!-- list.jsp -->