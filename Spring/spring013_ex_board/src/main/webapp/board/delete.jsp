<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang ="ko">
<%@ include file="../inc/JOAbooks_header.jsp" %>
<!-- header -->
<!-- header -->
	<div class = "contanier card m-5 p-3">
		<h3 class="card-header"> <i class="bi bi-brush m-1"></i> TITLE:  ${dto.btitle}</h3>
		<table class="text-center">
			<tr>
				<td> <i class="bi bi-balloon-heart m-1"></i> NO:${dto.bno} </td>
				<td> <i class="bi bi-cast m-1"></i> NAME:${dto.bname} </td>
				<td> <i class="bi bi-book-half m-1"></i> 조회수:${dto.bhit}</td>
			</tr>
		</table>
		<hr/>
		<div class="card-body text-center">
			<p> ${ dto.bcontent } </p>
		</div>
		<div>
		<script>
			function form(){
				let temppass = document.querySelector("#temppass");
				let bpass = document.querySelector("#bpass").value;
				if(pass.value == ""){
					alert("비밀번호를 입력하세요."); pass.focus(); return false;
				} else if(temppass.equals(bpass)){
					alert("올바른 비밀번호를 입력하세요."); pass.focus(); return false;
				};
				
			}
		</script>
			<form action="${pageContext.request.contextPath}/board/delete?bno=${dto.bno}" method = "post" onsubmit = "return form()" >
				
				<input type="hidden" name="bno" value="${dto.bno}" readonly>
				<input type="hidden" name="bpass" value="${dto.bpass}" readonly >
				
				<div class="mb-3 mt-3">
					<label for="temppass" class="form-label">삭제하시려면 비밀번호를 입력해주세요. </label>
					<input type="text" class="form-control" id="temppass" placeholder="비밀번호를 입력하세요." name="temppass">
				</div>
				
				<div class = "d-flex justify-content-end m-3">
					<a href = "${pageContext.request.contextPath}/board/list" class = "btn btn-outline-success m-1">취소</a>
					<button type="submit" title ="삭제하기" class="btn btn-success m-1">삭제</button>
				</div>
			</form>
		</div>
	</div>
<!--  footer -->
<!--  footer -->
<%@ include file="../inc/JOAbooks_footer.jsp" %>