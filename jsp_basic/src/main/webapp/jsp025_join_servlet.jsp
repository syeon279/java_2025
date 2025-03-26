<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- jsp025.jsp -->
<!-- jsp025.jsp -->
<%@ include file="jsp022_header.jsp" %>
<!--  nav -->
<!--  nav -->
	<div class = "contanier card m-5 p-5">
		<div class = " p-5">
			<p style="text-align:center"><img src="images/login.png" alt = "login"></p>
		</div>
		
		<form action="<%=request.getContextPath()%>/user_join" method="post" onsubmit="return form()">
		  <div class="my-3">
		    <label for="id" class="form-label">Id: </label>
		    <input type="text" class="form-control" id="id" name="id">
		  </div>
		   <div class="my-3">
		    <label for="pass" class="form-label">Password: </label>
		    <input type="password" class="form-control" id="pass" name="pass">
		  </div>
		  <div class="my-3">
		  <input type="checkbox" name="remember"> remember
		  <label for="remember" class="form-label"></label>
		  </div>
		  <div class="my-3">
		  <button type="submit" title ="로그인 하러가기" class="btn btn-danger">로그인</button>
		  </div>
		</form>
		<script>
			function form(){
				let id = document.querySelector("#id");
				let pass = document.querySelector("#pass");
				
				if(id.value == ""){
					alert('아이디를 입력해주세요'); id.focus(); return false;
				}
				if(pass.value == ""){
					alert('비밀번호를 입력해주세요'); pass.focus(); return false;
				}
			}
		</script>
	</div>
<!-- jsp022.jsp -->
<!-- jsp022.jsp -->

<!--  footer.jsp -->
<!--  footer.jsp -->
<%@ include file="jsp022_footer.jsp" %>