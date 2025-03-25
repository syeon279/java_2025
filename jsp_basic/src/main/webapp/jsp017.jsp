<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
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
	<div class = "contanier card m-5">
		<h3 class="card-header bg-warning"> SELECT BOX </h3>
		 <div class="card-body" style = "padding-left: 50px; padding-right: 50px;"> 
	     	<form action = "jsp017_2.jsp" method = "post" onsubmit = "return form()">
				<div class="mb-3 mt-3 p-3">
			  			<label for="username" class="form-label" style = "font-style:italic">NAME:</label>
			  			<input type="text" class="form-control" id="username" placeholder="Enter username" name="username">
			 	</div> 
			 	<div class="mb-3 mt-3 p-3" >
				 	<label for ="fruit"> 좋아하는 선택 </label>
				 	<select class="form-select" id= "fruit" name = "fruit">
						<option value=""> 선택 </option>
						<option value="apple"> Apple </option>
						<option value="banana"> Banana </option>
						<option value="coconut"> Coconut </option>
					</select>
					<div class ="my-3">
						<button type = "submit" class = "btn btn-danger">전송</button>	  	
				  	</div>
			 	</div>
			</form>
	     	<script>
	     		function form() {
	     			let username = document.querySelector("#username");
	     			let    fruit = document.querySelector("#fruit > option:checked");
	     			
	     			if(username.value == ""){
	     				alert('입력해주세요.'); username.focus(); return false;
	     			}
	     			if( fruit.value == ""){
	     				alert('옵션을 선택해주세요.'); fruit.focus(); return false;
	     			}
	     		}
	     	</script>
      </div>
	</div>
</body>
</html>