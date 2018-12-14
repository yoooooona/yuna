<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Response 예제</h3>
	<%
		//response2 페이지가 나옴 뒤로 가기 눌러도 response1페이지는 나오지 않음
		//response.sendRedirect("response2.jsp");
		response.sendRedirect("http://www.naver.com");
		
	%>
</body>
</html>