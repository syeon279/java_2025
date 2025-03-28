<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp" %>

<div class="container   my-5">
	<h3> NAVER BOOK</h3>
	<div class="result">
	</div>
	
	<script>
	//1.window.onload = function(){};  브라우저 로딩되면 동작
	// $() jquery   
	$(function(){
		 
		$.ajax({
			url:"${pageContext.request.contextPath}/books",
			dataType:"json", 
			type:"GET",
			success:function(json){   //Obejct
				/*
				//1. 데이터 분해
				//console.log(json); 
				let  items = json.items;
				//console.log(items[0]); // 객체1개  items[0] = {title:"", image:"",,,,};
				
				for(let i=0; i<items.length; i++){
					let div = $('<div class="card my-3 row">');   //<div></div>  태그만들기
					let p1  = $('<div class="card-body">').html('<img src="'+items[i].image+'" />');
					let p2  = $('<div class="card-body">').html( items[i].title );  //html reset해서 넣기
					div.append(p1).append(p2);  // div태그안에 p1추가하고 p2추가
					$(".result").append(div);
				}
				//2. 보여줄화면에 껴넣기
				*/

				  let items = json.items;
				  for(let i=0; i<items.length; i++){ 
					var div12 = $('<div class="row  my-3">');
				   	var div4 = $('<div class="col-sm-4  naverimg">').html(
				   			'<img src="'+ items[i].image +'" style="width:100%"  alt=""/>');
					var div8 = $('<div class="col-sm-8">').html(
						     '<a href="'+items[i].link +'"><p>'+ items[i].title
									+'</p><p>'+  items[i].author
									+'</p><p>'+  items[i].pubdate
									+'</p><p>'+  items[i].price
									+'</p></a>');
					div12.append(div4).append(div8);
					$(".result").append(div12);
				}
				
			},error:function(xhr, textStatus, errorThrown){
				$(".result").html(textStatus + "(HTTP-" + xhr.status + "/" + errorThrown);
			} // $(".result")  document.querySelector(".result")
		});
		
	});  // 2. jQuery 브라우저 로딩되면 동작
	</script>
</div>

<div class="container   my-5">
	<h3 class="card-header  mb-3">MULTIBOARD</h3>
<%-- 	<%=request.getAttribute("list")%>       --%>
	<table  class="table table-striped  table-bordered table-hover text-center">
		<caption>MULTIBOARD-LIST</caption>
		<thead>
			<tr><th scope="col">NO</th><th scope="col">TITLE</th>
			      <th scope="col">WRITER</th><th scope="col">DATE</th><th scope="col">HIT</th></tr>
		</thead>
		<tbody>
			<!-- 	for(  BoardDto dto :  list)			 -->
			<c:forEach     var="dto"  items="${list}"   varStatus="status">
				<tr>
					<td>${list.size() - status.index}</td>  <%-- 전체 5-(0,1,2,,) --%>
					<td><a href="detail.do?bno=${dto.bno}">${dto.btitle}</a></td>
					<td>${dto.bname}</td>
					<td>${dto.bdate}</td>
					<td>${dto.bhit}</td>
				</tr>
			</c:forEach> 
		</tbody>
	</table>
	<p  class="text-end"><a href="write_view.do"   class="btn btn-primary">글쓰기</a></p>
</div>

<%@ include file="../inc/footer.jsp" %>