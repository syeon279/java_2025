<%@ page language="java" contentType="text/html; charSet=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../inc/header.jsp"%>
<!-- header -->
<!-- header -->
	<div class="container  card  my-3  p-3 w-50">
		<h3 class="card-header"> WELCOME 로그인 </h3>
		<form:form method="post" action="${pageContext.request.contextPath}/member/login" modelAttribute="memberLoginForm">
			<%-- <form:errors path="*" cssClass="text-primary text-center"/> --%>
			<div class="my-3">
				<!-- 사용자 아이디 -->
				<label for="">사용자 ID</label>
				<form:input path="username" cssClass="form-control"/>
				<form:errors path="username" cssClass="form-control"/>
				
				<!-- 비밀번호 -->
				<label for="">Password </label>
				<form:input path="password" cssClass="form-control"/>
				<form:errors path="password" cssClass="form-control"/>
			</div>
			<div class="my-3">
				<Button type="submit">로그인</Button>
			</div>
		</form:form>
	</div>
<!-- footer -->
<!-- footer -->
