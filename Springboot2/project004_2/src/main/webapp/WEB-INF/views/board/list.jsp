<%@ page language="java" contentType="text/html; charSet=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../inc/header.jsp"%>

<div class="container my-5">
	<h3>MULTIBOARD</h3>
	<%-- ${list} --%>
	<hr />
	<%-- ${paging} --%>

	<c:set var="total" value="${empty paging.listtotal? 0 : list.size()}"></c:set>
	<table
		class="table table-striped table-bordered table-hover text-center">
		<caption>MULTIBOARD-LIST</caption>
		<thead>
			<tr>
				<th scope="col">NO</th>
				<th scope="col">TITLE</th>
				<th scope="col">WRITER</th>
				<th scope="col">DATE</th>
				<th scope="col">HIT</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="dto" items="${list}" varStatus="state">
				<tr>
					<td>${total - (pageNumber*pageSize) - state.index}</td>
					<td><a
						href="${pageContext.request.contextPath}/board/detail/${dto.id}">${dto.btitle}</a></td>
					<td>${dto.member.nickname}</td>
					<td><fmt:formatDate value="${dto.createDate}"
							pattern="yyyy-MM-dd HH:mm" /></td>
					<td>${dto.bhit}</td>
				</tr>
			</c:forEach>
		</tbody>

		<tfoot>
			<tr>
				<td colspan="5">
					<ul class="pagination justify-content-center">
						<!-- 이전 페이지 -->
						<c:if test="${paging.start >= paging.bottomlist}">
							<li class="page-item">
								<a class="page-link"
								href="${pageContext.request.contextPath}/board/list?page=${paging.start-2}">이전</a>
							</li>
						</c:if>
						
						<c:forEach begin="${paging.start}" end="${paging.end}" var="i">
							<li class="page-item ${paging.current == i ? 'active' : ''}">
								<a class="page-link"
								href="${pageContext.request.contextPath}/board/list?page=${i-1}">${i}</a>
							</li>
						</c:forEach>
	

						<!-- 다음 페이지 -->
						<c:if test="${paging.pagetotal > paging.end}">
							<li class="page-item">
								<a class="page-link"
								href="${pageContext.request.contextPath}/board/list?page=${paging.end}">다음으로</a>
							</li>
						</c:if>

					</ul>
				</td>
			</tr>
		</tfoot>
	</table>

	<p class="text-end">
		<a href="${pageContext.request.contextPath}/board/insert" class="btn btn-primary">글쓰기</a>
	</p>
</div>

<%@ include file="../inc/footer.jsp"%>
