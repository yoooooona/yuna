<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>다음과 같은 에러가 발생하였습니다.</p>
	<!-- jsp는 exception(내장객체)의 변수명이 정해져 있다.-->
	<%=exception.getMessage()%>
</body>
</html>