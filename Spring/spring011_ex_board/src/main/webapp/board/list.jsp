<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang ="ko">
<%@ include file="../inc/JOAbooks_header.jsp" %>
<!-- header -->
<!-- header -->

	<div class = "contanier card m-5 p-3">
		<h3 class="card-header">게시판</h3>
		<table class = "table table-header text-center">
			<caption class = "text-center">글 목록</caption>
			<thead>
				<tr>
					<td><i class="bi bi-balloon-heart m-1"></i>No</td>
					<td><i class="bi bi-brush m-1"></i>Title</td>
					<td><i class="bi bi-cast m-1"></i>Name</td>
					<td><i class="bi bi-calendar-event m-1"></i>Date</td>
					<td><i class="bi bi-book-half m-1"></i> Hit</td>
				</tr>
			</thead>
			<tbody>
	 			<c:forEach items="${ list }" var="l" varStatus="status">
					<tr>
		 				<td>${ list.size() - status.index}</td>
						<td><a href = "detail.do?bno=${l.bno}">${ l.btitle }</a></td>
						<td>${ l.bname }</td>
						<td>${ l.bdate }</td>
						<td>${ l.bhit }</td> 
					</tr>
				</c:forEach> 
			</tbody>
		</table>

		<div class = "d-flex justify-content-end m-3">
			<a href = "/write" class = "btn btn-success">글쓰기</a>
		</div>
	</div>
	<div class = "contanier card m-5 p-3">
	<h3>NAVER BOOK</h3>	
	<div class = "result">

	</div>	
	<script>
 	$(function () {
		// jQuery야 동작해줘
		$.ajax({
			url: "${pageContext.request.contextPath}/books", 
			dataType:"json",
			type: "GET",
			success:function(json){
				let items = json.items;
				
				for(let i=0; i<items.length; i++){
					let row = $('<div class="row m-2">');
					let col= $('<div class = "col">')
					let div = $('<div class="p-3 border" style="width:250px; height:400px" >'); // div 태그 만들기/
					let p1 = $('<div class ="p-3" >').html('<img src="'+ items[i].image +'" class="img-fluid" />');
					let p2 = $('<div>').html(items[i].title);
					div.append(p1).append(p2);
					col.append(div);
					
					$(".row").append(col);
					// div 태그 안에 p1 안에 추가하고 p2추가 
					// html reset해서 넣기  
					$(".result").append(row);
				};
				//보여줄 화면에 끼워넣기 
			}, error:function(xhr, textStatus, errorThrown){
				$(".result").html(textStatus + "(HTTP-"+xhr.status +"/"+errorThrown +")");
			};
		});
	});
	</script>	
	</div>
<!--  footer -->
<!--  footer -->
<%@ include file="../inc/JOAbooks_footer.jsp" %>