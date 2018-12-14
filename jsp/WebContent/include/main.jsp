<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<h3>본문 영역</h3>
<form>
	이름 : <input type="text">
	<input type="button" value="전송">
</form>
<%
	//int i=10;  //include 지시어는 하나로 합친 다음에 컴파일을 하기 때문에
					// 중복된 변수 선언 불가
%>
<%@include file="footer.jsp"%>