<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../include/header.jsp"%>
<!-- Main content -->
<section class="content">
	<div class="box box-primary">
		<div class="box-header">
			<h3 class="box-title">List Board</h3>
		</div>
		<div class="row">
			<div class="col-md-4">
				<input type="button"
					onclick="location.href='views/qna_board_write.jsp'" value="글쓰기"
					class="btn btn-success">
			</div>
			<!--글쓰기 버튼-->
			<div class="col-md-4 offset-md-4">
				<!--검색 들어갈 부분-->
				<form action="search.do" method="post" name='search'>
					<select name="criteria">
						<option value="n" <c:out value="${search.criteria eq null?'selected' :''}"/>>------</option>
						<option value="title" <c:out value="${search.criteria eq 'title'?'selected' :''}"/>>title</option>
						<option value="content" <c:out value="${search.criteria eq 'content'?'selected' :''}"/>>content</option>
						<option value="name" <c:out value="${search.criteria eq 'name'?'selected' :''}"/>>name</option>
					</select> <input type="text" name="keyword" value="${search.keyword}"> 
					<input type="button" value="검색" class="btn btn-primary">
				</form>
			</div>
		</div>
		<br>
		<table class="table table-bordered">
			<tr>
				<th class='text-center' style='width: 100px'>번호</th>
				<th class='text-center'>제목</th>
				<th class='text-center'>작성자</th>
				<th class='text-center'>날짜</th>
				<th class='text-center' style='width: 100px'>조회수</th>
			</tr>
			<c:forEach var="vo" items="${list}">
				<tr>
					<!-- 리스트 목록 보여주기 -->
					<td class='text-center'>${vo.bno}</td>
					<td>
						<%-- 댓글인지를 명확히 하기 위해 들여쓰기 --%> <c:if test="${vo.re_lev!=0}">
							<c:forEach begin="0" step="1" end="${vo.re_lev*1}">
						&nbsp;
					</c:forEach>
						</c:if> <a href="hitUpdate.do?bno=${vo.bno}&page=${info.page}&criteria=${search.criteria}&keyword=${search.keyword}">${vo.title}</a>
					</td>
					<td class='text-center'>${vo.name}</td>
					<td class='text-center'>${vo.regdate}</td>
					<td class='text-center'><span
						class="badge badge-pill badge-primary">${vo.readcount}</span></td>
				</tr>
			</c:forEach>
		</table>
		<div class="container">
			<div class="row  justify-content-md-center">
				<nav aria-label="Page navigation example">
					<ul class="pagination">
						<!--하단의 페이지 나누기 부분-->
						<li class="page-item">
						<c:if test="${info.page<=1}">
								<a class="page-link">Previous</a>
						</c:if>
						<c:if test="${info.page>1}">
						<c:choose>
							<c:when test="${searh.criteira==null}">
							<a class="page-link" href="select.do?page=${info.page-1}">Previous</a>
							</c:when>
							<c:otherwise>
							<a class="page-link" href="search.do?page=${info.page-1}&criteria=${search.criteria}&keyword=${search.keyword}">Previous</a>
							</c:otherwise>
						</c:choose>
						</c:if>
						<c:forEach begin="${info.startPage}" end="${info.endPage}" var="idx">
							 <c:choose>
								 <c:when test="${idx==info.page}">
								 	<li class="page-item"><a class="page-link">${idx}</a></li>
								 </c:when>
								 <c:otherwise>
								 	<c:choose>
								 	<c:when test="${search.criteria==null}">
								 		<li class="page-item">
								 		<a class="page-link" href="select.do?page=${idx}">${idx}</a></li>
								 	</c:when>
								 	<c:otherwise>
								 		<li class="page-item">
								 		<a class="page-link" href="search.do?page=${idx}&criteria=${search.criteria}&keyword=${search.keyword}">${idx}</a></li>
								 	</c:otherwise>
								 	</c:choose>
								 </c:otherwise>
							 </c:choose>
						</c:forEach>
						<c:if test="${info.page>=info.totalPage}">
						<li class="page-item"><a class="page-link" href="">Next</a>
					</c:if>
					<c:if test="${info.page<info.totalPage}">
					<c:choose>
					<c:when test="${search.criteria==null}">
						<li class="page-item">
						<a class="page-link" href="select.do?page=${info.page+1}">Next</a>
						</li>
						</c:when>
						<c:otherwise>
						<li class="page-item">
						<a class="page-link" href="search.do?page=${info.page+1}&criteria=${search.criteria}&keyword=${search.keyword}">Next</a>
						</c:otherwise>
						</c:choose>
						</c:if>
					</ul>
				</nav>
			</div>
		</div>
		<div style="height: 20px"></div>
	</div>
</section>
<script>
	$(function(){
		//# = 아이디를 끌고올때
		$(".btn-primary").click(function(){
			if($("select[name='criteria']").val()=='n'){
				alert("검색 조건을 선택하세요");
				$("select[name='criteria']").focus();
				return;
			}else if($("input[name='keyword']").val()==""){
				alert("검색어를 선택하세요");
				$("input[name='keyword']").focus();
				return;
			}
			$("form[name='search']").submit();
		});
	});
</script>
<%@include file="../include/footer.jsp"%>
