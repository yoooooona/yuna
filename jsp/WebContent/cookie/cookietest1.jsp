<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Cookie c=new Cookie("name","honggildong");
    	//쿠키 유효기간 설정	
   		c.setMaxAge(600);
    	response.addCookie(c);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cookietest1</title>
</head>
<body>
	<a href="getCookie1.jsp">쿠키 확인</a>
</body>
</html>