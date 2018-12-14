<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%  //세션 값 설정하기
		session.setAttribute("name", "sessionTest1");
		session.setAttribute("id","hong12345");
		response.sendRedirect("sessionTest1.jsp");
	%>
</body>
</html>