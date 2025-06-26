<%@ page language="java" contentType="text/html; charSet=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../inc/header.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!--  END HEADER -->
<!--  END HEADER -->
<!--  END HEADER -->

<script src="https://cdn.ckeditor.com/4.25.1-lts/standard/ckeditor.js"></script>
<div class="container  my-5">
	<h3>MULTIBOARD - 글쓰기</h3>
	<form:form action="${pageContext.request.contextPath}/board/insert"
		modelAttribute="boardForm" method="post" enctype="multipart/form-data"
		id="writeForm">
		<fieldset>
			<legend>WRITE(CREATE)</legend>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			<div class="my-2">
				<label for="bname">이름</label> <input type="text" 
					id="bname" readonly value="${ username }" class="form-control">
				<form:input path="memberId" id="memberId" type="hidden" cssClass="form-control" />
				<form:errors path="memberId" cssClass="text-primary" />
			</div>
			<div class="my-2">
				<label for="bpass">비밀번호</label>
				<form:password path="bpass" id="bpass" cssClass="form-control" />
				<form:errors path="bpass" cssClass="text-primary" />
			</div>
			<div class="my-2">
				<label for="btitle">제목</label> 
				<form:input path="btitle" id="btitle" cssClass="form-control" />
				<form:errors path="btitle" cssClass="text-primary" />
			</div>
			<div class="my-2">
				<label for="bcontent">내용</label>
				<form:textarea rows="10" cols="60" path="bcontent" id="bcontent"
					cssClass="form-control" />
				<form:errors path="bcontent" bcontent="bcontent"
					cssClass="text-primary" />
			</div>
			<div class="my-3">
				<label for="file" class="form-label">파일</label> <input type="file"
					name="file" id="file" class="form-control">
			</div>
			<div class="my-2  text-end">
				<input type="submit" value="입력" class="btn btn-primary">
				<input type="reset" value="취소" class="btn btn-default">
				<a href="${pageContext.request.contextPath}/board/list"
					class="btn btn-default">목록보기</a>
			</div>
		</fieldset>
	</form:form>
	<!-- end form -->
</div>

<!-- END FOOTER -->
<!-- END FOOTER -->
<!-- END FOOTER -->
<!-- END FOOTER -->
<%@ include file="../inc/footer.jsp"%>