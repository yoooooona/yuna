<%@page import="test.LoginVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String id=request.getParameter("id");
    	String pwd=request.getParameter("pwd");
    	session.setAttribute("login", new LoginVO(id,pwd));
    	response.sendRedirect("login.jsp");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>