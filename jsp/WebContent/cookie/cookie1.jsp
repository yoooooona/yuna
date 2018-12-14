<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cookie1</title>
</head>
<body>
	<% 
		response.addCookie(new Cookie("name","Hong"));
		response.addCookie(new Cookie("gender","Male"));
		response.addCookie(new Cookie("age","35"));
	%>
	<h3>쿠키 데이터 저장</h3>
	<a href="getCookie.jsp">확인하러 가기</a>
</body>
</html>