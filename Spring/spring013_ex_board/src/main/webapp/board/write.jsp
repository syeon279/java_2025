<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../inc/JOAbooks_header.jsp" %>
<!-- header -->
<!-- header -->
	<div class = "contanier card m-5 p-5" style="margin-left:100px; margin-right:100px;">
		<h3 class="card-header"> 글쓰기 </h3>
		<form action="${pageContext.request.contextPath}/board/create" method = "post" onsubmit = "return form()">
			<div class="mb-3 mt-3">
				<label for="bname" class="form-label">이름: </label>
				<input type="text" class="form-control" id="bname" placeholder="이름을 입력하세요." name="bname">
			</div>
			<div class="mb-3 mt-3">
				<label for="bpass" class="form-label">비밀번호: </label>
				<input type="text" class="form-control" id="bpass" placeholder="이름을 입력하세요." name="bpass">
			</div>
			<div class="mb-3">
			    <label for="btitle" class="form-label">제목 :</label>
			    <input type="text" class="form-control" id="btitle" placeholder="제목을 입력하세요." name="btitle">
			</div>
			<div>
			  	<label for="bcontent">내용 :</label>
				<textarea class="form-control" rows="5" id="bcontent" name="bcontent"></textarea>
			</div>
			<div class = "d-flex justify-content-end m-3">
			  	<button type="submit" title ="작성하기" class="btn btn-success m-1">올리기</button>
			  	<a href="list" class="btn btn-outline-success m-1"> 취소 </a>
				<a href="list" class="btn btn-outline-success m-1"> 목록보기 </a>
			</div>
		</form>
	<script>
		function form() {
			let name = document.querySelector("#name");
			let title = document.querySelector("#title");
			let content = document.querySelector("#content");
			let pass = document.querySelector("#pass");
			if(name.value == "") {
				alert('이름을 작성해주세요.'); name.focus(); return false;
			}
			if(title.value == "") {
				alert('제목을 작성해주세요.'); title.focus(); return false;
			}
			if(content.value == "") {
				alert('내용을 작성해주세요.'); content.focus(); return false;
			}
			if(pass.value == "") {
				alert('비밀번호를 입력해주세요.'); pass.focus(); return false;
			}
		}
	</script>
	</div>
	
<!--  footer -->
<!--  footer -->
<%@ include file="../inc/JOAbooks_footer.jsp" %>