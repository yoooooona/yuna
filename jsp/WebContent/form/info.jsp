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
		// post로 보냈기 때문에 한글로 보냈을 때 한글 깨짐 =request.setCharacterEncoding을 해줘야됨
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		String addr=request.getParameter("addr");
	%>
	<h3>이름 : <%=name%></h3>
	<h3>주소 : <%=addr%></h3>
</body>
</html>