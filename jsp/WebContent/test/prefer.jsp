<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	request.setCharacterEncoding("utf-8");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>선호도 조사</h3>
	<%-- 좋아하는 음식은<%=session.getAttribute("food") %>이고, --%>
	좋아하는 음식은<%=request.getAttribute("food") %>이고,
	좋아하는 동물은<%=request.getParameter("animal") %>입니다.
</body>
</html>