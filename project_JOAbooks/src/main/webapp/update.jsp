<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="inc/JOAbooks_header.jsp" %>
<!-- header -->
<!-- header -->

	<div class = "contanier card m-5 p-3">
		<h3 class="card-header"> 수정하기 </h3>
			<div class="card-body mb-3 mt-3 d-flex justify-content-around">
				<p>글쓴이: </p>
				<p><%= session.getAttribute("bname") %></p>
			</div>
		<form action="#" method = "get" onsubmit="return form2()">
			  <div class="mb-3">
			    <label for="title" class="form-label">제목 :</label>
			    <input type="text" class="form-control" id="title" placeholder="제목을 입력하세요." name="title">
			  </div>
			  <div>
			  	<label for="content">내용 :</label>
				<textarea class="form-control" rows="5" id="content" name="content"></textarea>
			  </div>
			  <div class = "d-flex justify-content-end m-3">
			  	<button type="submit" title ="작성하기" class="btn btn-success m-1">수정하기</button>
				<a href="" class="btn btn-outline-success m-1"> 취소 </a>
				<a href="" class="btn btn-outline-success m-1"> 목록보기 </a>
			  </div>
		</form>
	</div>
	<script>
		function form2(){
			alert('hi');
			let title = document.querySelector("#title");
			let content = document.querySelector("#content");
			
			if(title.value == "") {
				alert('제목을 작성해주세요.'); title.focus(); return false;
			}
			if(content.value == "") {
				alert('내용을 작성해주세요.'); content.focus(); return false;
			}
		}
		
	</script>
	
<!--  footer -->
<!--  footer -->
<%@ include file="inc/JOAbooks_footer.jsp" %>