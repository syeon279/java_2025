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
				<td> <i class="bi bi-balloon-heart m-1"></i> NO   ${dto.bno} </td>
				<td> <i class="bi bi-cast m-1"></i> NAME    ${dto.bname} </td>
				<td> <i class="bi bi-book-half m-1"></i>  조회수   ${dto.bhit}</td>
			</tr>
		</table>
		<hr/>
		<div class="card-body text-center">
			<p> ${ dto.bcontent } </p>
		</div>
		<div class = "d-flex justify-content-end m-3">
			<a href = "${pageContext.request.contextPath}/board/update?bno=${dto.bno}" class = "btn btn-success m-1">수정</a>
			<a href = "${pageContext.request.contextPath}/board/delete?bno=${dto.bno}" class = "btn btn-success m-1">삭제</a>
			<a href = "${pageContext.request.contextPath}/board/list" class = "btn btn-outline-success m-1">목록보기</a>
		</div>
	</div>
<!--  footer -->
<!--  footer -->
<%@ include file="../inc/JOAbooks_footer.jsp" %>