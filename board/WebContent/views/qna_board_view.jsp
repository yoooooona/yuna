<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String cur_page=request.getParameter("page");
    %>
<%@include file="../include/header.jsp"%>
<!-- Main content -->
<section class="content">
	<div class="box box-primary">
		<div class="box-header">
			<h3 class="box-title">Read Board</h3>
		</div>
		<div style="height:20px"></div>
		<form action="" method="post" role="form">
			<div class="box-body">
				<div class="form-group row">
					<label for="name" class="col-sm-2 col-form-label">글쓴이</label>
					<div class="col-sm-10">
						<input type="text" name="name" size="10" class="form-control" maxlength='10' value="${vo.name}" readonly="readonly">
					</div>
				</div>
				<div class="form-group  row">
					<label for="title" class="col-sm-2 col-form-label">제목</label>
					<div class="col-sm-10">
						<input type="text" name="title" size="50" class="form-control"	maxlength='100' value="${vo.title}" readonly="readonly">
					</div>
				</div>
				<div class="form-group  row">
					<label for="content" class="col-sm-2 col-form-label">내용</label>
					<div class="col-sm-10">
						<textarea name='board_content' cols='60' class="form-control" rows='15' readonly="readonly">${vo.content}</textarea>
					</div>
				</div>
				<div class="form-group  row">
					<label for="filename" class="col-sm-2 col-form-label">파일첨부</label>
					<div class="col-sm-10">
					<!-- 파일명이 uuid 값이 붙어 있는 상태이므로 순수 파일명만 보여주기 -->
					<c:if test="${!empty vo.file}">
					<c:set value="${vo.file}" var="file"></c:set>
					<%
						String file=(String)pageContext.getAttribute("file");
						int start=file.lastIndexOf("_");
						pageContext.setAttribute("file",file.substring(start+1));
					%>
					</c:if>
					<c:choose>
					<c:when test="${empty vo.file}">
						첨부파일 없음
					</c:when>
					<c:when test="${!empty vo.file}">
					<a href="views/filedownload.jsp?fileName=${vo.file}">${file}</a>
					</c:when>
					</c:choose>
					</div>
				</div>
				<div style="height:10px"></div>
				<div class="box-footer text-center">
					<button type="button" class="btn btn-success" id="reply">답변</button>
					<button type="button" class="btn btn-warning" id="modify">수정</button>
					<button type="button" class="btn btn-danger" id="delete">삭제</button>
					<button type="button" class="btn btn-primary" id="list">목록보기</button>
				</div>
				<div style="height:20px"></div>
			</div>
		</form>
	</div>
</section>
<form method="post" role="form">
	<input type="hidden" value="${vo.bno}" name="bno">
	<input type="hidden" value='<%=request.getParameter("page")%>' name="page">
	<%-- <input type="hidden" value="${page}" name="page"> --%>
	<%-- 페이지 검색 후 추가 --%>
	<input type="hidden" value='${search.criteria}' name="criteria">
	<input type="hidden" value='${search.keyword}' name="keyword">
	</form>
<script>
	$(function(){
		//form 가져오기
		var formObj=$("form[role='form']");
		$("#delete").click(function(){
			formObj.attr("action","views/qna_board_pwdCheck.jsp");
			formObj.submit();
		});
		$("#modify").click(function(){
			formObj.attr("action","modify.do");
			formObj.submit();
		});
		$("#reply").click(function(){
			formObj.attr("action","replyView.do");
			formObj.submit();
		});
		$("#list").click(function(){
			var criteria=$("input[name='criteria']").val();
			var keyword=$("input[name='keyword']").val();
			console.log(criteria);
			if(criteria!='' && keyword!=''){
				formObj.attr("action","search.do");
			}else{
				formObj.attr("action","select.do");
			}
			formObj.submit();
		});
	});
</script>
<%@include file="../include/footer.jsp"%>
