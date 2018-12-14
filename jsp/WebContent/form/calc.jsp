<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String num1=request.getParameter("num1");
	String num2=request.getParameter("num2");
	String op=request.getParameter("op");
%>
	<h3>두 수의 사칙연산 결과 값 : <%=num1+op+num2%></h3>
</body>
</html>