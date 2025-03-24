<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<div class = "container card my-5 p-3 ">
		<h3 class="card-header bg-success" style = "text-align:center; color:white"> 내장 객체 </h3>
		<pre class="card-body" >
		1. jsp 페이지가 웹컨테이너에 의해 서블릿으로 변환 될 때
		2. 고정된 이름의 객체 컨테이너로 자동으로 구현
		3. request(요청), response(응답), session(정보저장), out(출력)
		</pre>
	</div>
	
	<div class = "container card my-5 p-3">
		<h3 class="card-header bg-success " style = "text-align:center; color:white">request(요청)</h3>
		<pre class="card-body">
		1. action = "처리 컴포넌트"
		2. method = "처리방식"
		3. name = "사용자가 입력한 값 보관이름"
		</pre>
		<form action="jsp015_checkbox.jsp" method = "get"  onsubmit="return checkbox()" >
		  	<div class="mb-3 mt-3 p-3" >
		  		<div>
		  			<label for="username" class="form-label" style = "font-style:italic">NAME:</label>
		  			<input type="text" class="form-control" id="username" placeholder="Enter username" name="username">
		 		</div> <!--  user name -->
		 	<script>
		 	function checkbox(){
		 		let name = document.getElementById("username");
		 		let checkboxs = document.querySelectorAll(".form-check-input:checked")
		 		console.log(checkboxs);
		 		console.log(checkboxs.length);
		 		
		 		
		 		if( name.value == ""){
		 			alert("입력해주세요"); name.focus(); return false;
		 		}
		 		if( checkboxs.length == 0){
		 			alert("한 개 이상 선택해주세요."); return false;
		 		}
		 	}
		 	</script>
		  	<div class="form-check">
	 			<input class="form-check-input" type="checkbox" id="check1" name="animal" value="dog" >
	  			<label class="form-check-label" for = "check1">DOG</label>
		  	</div>
		  	<div class="form-check">
	  			<input class="form-check-input" type="checkbox" id="check2" name="animal" value="cat" >
	  			<label class="form-check-label" for = "check2" >CAT</label>
		  	</div>
		  	<div class="form-check">
	  			<input class="form-check-input" type="checkbox" id="check3" name="animal" value="hamster">
	  			<label class="form-check-label" for = "check3" >HAMSTER</label>
		  	</div>
		  	<div class ="my-3">
				<button type = "submit" class = "btn btn-danger">전송</button>	  	
		  	</div>
		  	</div>
		</form>
	</div>
	<!--  check box -->
	<!--  check box -->
	
	<div class = "container card my-5 p-3">
		<h3 class="card-header bg-success " style = "text-align:center; color:white"> request(요청) - radio</h3>
		<form action="jsp015_radio.jsp" method = "get"  onsubmit = "return check2() " >
			<div class="mb-3 mt-3 p-3">
		  		<label for="usernameR" class="form-label" style = "font-style:italic">NAME:</label>
		  		<input type="text" class="form-control" id="usernameR" placeholder="Enter username" name="usernameR">
		 	</div> 
		 	<!--  user name -->
		 	<!--  user name -->
			<div class="form-check">
	 			<input type="radio" class="form-check-input1" id="radio1" name="optradio" value="yes" style="margin-right:10px"> yes
				<label class="form-check-label" for="radio1"></label>
			</div>
			<div class="form-check">
	 			<input type="radio" class="form-check-input1" id="radio1" name="optradio" value="no" style="margin-right:10px" > no
				<label class="form-check-label" for="radio1"></label>
			</div>
			<div class="form-check">
	 			<input type="radio" class="form-check-input1" id="radio1" name="optradio" value="option1" disabled style="margin-right:10px"> 사용 못함-disabled <label class="form-check-label" for="radio1"></label>
			</div>
			<!-- radio -->
			<!-- radio -->
			<div class ="my-3">
				<button type = "submit" class = "btn btn-danger">전송</button>	  	
		  	</div>
		</form>
		<script>
			function check2() {
			//alert("hi"); return false;
				let username = document.querySelector("#usernameR");
				let radios   =  document.querySelectorAll(".form-check-input1:checked");
				console.log(radios.length);
				if( username.value == "" ){
					alert("입력해주세요"); username.focus(); return false;
				} 
				if( radios.length == 0 ) {
					alert("한 개 이상 선택해주세요."); return false;
				} 
			}
		</script>
	</div >
	<!--  radio -->
	<!--  radio -->
	
	<div class = "container card my-5 p-3" >
		<h3 class="card-header bg-success " style = "text-align:center; color:white"> request(요청) - select </h3>
		<form action="jsp015_select.jsp" method = "get"  onsubmit = "return check3() " >
			<div class="mb-3 mt-3 p-3">
		  		<label for="usernameS" class="form-label" style = "font-style:italic">NAME:</label>
		  		<input type="text" class="form-control" id="usernameS" placeholder="Enter username" name="usernameS">
		 	</div> 
		 	<!--  user name -->
		 	<!--  user name -->
		 	<div class="mb-3 mt-3 p-3" >
			 	<label for ="color"> 컬러 선택 </label>
			 	<select class="form-select" id= "color" name = "color">
					<option value="bg-danger">Red</option>
					<option value="bg-success">Green</option>
					<option value="bg-primary">Blue</option>
					<option value="bg-dark">Black</option>
				</select>
				<div class ="my-3">
					<button type = "submit" class = "btn btn-danger">전송</button>	  	
			  	</div>
		 	</div>
		</form>
		<script>
			function check3() {
				let username = document.querySelector("#usernameS");
				let color = document.querySelector("#color > option:checked");
				console.log(color.value);
				
				if( username.value == "" ){
					alert("입력해주세요."); username.focus(); return false;
				} 
				if (color.value==""){
					alert("선택해주세요."); color.focus(); return false;
				}
				
			}
		</script>
	</div>
</body>
</html>