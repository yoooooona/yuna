<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- include 지시어 대신으로 쓸 수 있는 형태 -->
<jsp:include page="header.jsp" />
<h3>본문 영역</h3>
<form>
	이름 : <input type="text"> <input type="button" value="전송">
</form>
<%
	int i = 20;
	out.print(i);
%>
<jsp:include page="footer.jsp" />