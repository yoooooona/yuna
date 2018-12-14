<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    //	request.setCharacterEncoding("utf-8");
    	RequestDispatcher rd=request.getRequestDispatcher("response3.jsp");
    	rd.forward(request,response);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>response2 페이지 입니다.</h3>
	<%-- <%=request.getParameter("name") %> --%>
</body>
</html>