<%@ page language="java" contentType="text/html; charSet=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../inc/header.jsp" %>

<div class="container"  style="margin-top:5%; min-height:500px">
		<h3>MULTIBOARD 삭제</h3>
		<form action="${pageContext.request.contextPath}/board/delete" 
			  method="post"   id="deleteForm"> 
			<div class="form-group">
			  <label for="bpass"  >비밀번호</label>
			  <input type="hidden"   name="id" value="${id}"    class="form-control" > 
			  <input type="password"   name="bpass"   id="bpass"   class="form-control" > 
			  <span>(*) 삭제시 필수입니다. </span>
			</div>
			<div class="form-group">
				<input type="submit" value=" 확 인 "   class="btn btn-danger" />
				<input type="reset"   onclick="history.go(-1);"  value="취소"    class="btn btn-info"  >  
			</div>	
		</form>
</div>
<%@ include file="../inc/footer.jsp" %>