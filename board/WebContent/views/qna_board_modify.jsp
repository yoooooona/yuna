<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<!-- Main content -->
<section class="content">
	<div class="box box-primary">
		<div class="box-header">
			<h3 class="box-title">Board Modify</h3>
		</div>
		<div style="height:20px"></div>
		<form action="update.do" method="post" role="form" enctype="multipart/form-data">
			<div class="box-body">
				<div class="form-group row">
					<label for="name" class="col-sm-2 col-form-label">글쓴이</label>
					<div class="col-sm-10" >
					<input type="text" name="name" size="10" class="form-control"	maxlength='10' value="${vo.name}" readonly="readonly">
					</div>
				</div>
				<div class="form-group row">
					<label for="title" class="col-sm-2 col-form-label">제목</label>
					<div class="col-sm-10">
						<input type="text" name="title" size="50" class="form-control"	maxlength='100' value="${vo.title}">
					</div>
				</div>
				<div class="form-group row">
					<label for="content" class="col-sm-2 col-form-label">내용</label>
					<div class="col-sm-10">
						<textarea name='content' cols='60' class="form-control" rows='15' value="${vo.content}"></textarea>
					</div>
				</div>
				<div class="form-group row">
					<label for="name" class="col-sm-2 col-form-label">비밀번호</label>
					<div class="col-sm-10">
						<input type="password" name="password" class="form-control" size="10" maxlength='10'>
					</div>
        </div>
				<div class="form-group row">
					<label for="filename" class="col-sm-2 col-form-label">파일첨부</label>
					<div class="col-sm-10">
						<!-- 파일 첨부가 안된 상태라면 다시 파일첨부를 할 수 있도록 만들어 주기 -->
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
						<input type="file" name="file">
					</c:when>
					<c:when test="${!empty vo.file}">
					<a href="views/filedownload.jsp?fileName=${vo.file}">${file}</a>
					</c:when>
					</c:choose>
					</div>
				</div>
				<div style="height:20px"></div>
				<div class="box-footer text-center">
					<button type="submit" class="btn btn-primary">수정</button>
					<button type="reset" class="btn btn-danger">취소</button>
				</div>
				<div style="height:20px"></div>
			</div>
			<input type="hidden" value="${vo.bno}" name="bno">
			<input type="hidden" value='<%=request.getParameter("page") %>' name="page">
			<input type="hidden" value='${search.criteria}' name="criteria">
			<input type="hidden" value='${search.keyword}' name="keyword">
		</form>
	</div>
</section>
<%@include file="../include/footer.jsp"%>
