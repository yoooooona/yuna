<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <h3>두 수의 덧셈 결과는 : <%=session.getAttribute("result")%></h3> --%>
<h3>두 수의 덧셈 결과는 : <%=request.getAttribute("result")%></h3>
<%-- <h3>두 수의 덧셈 결과는 : <%=application.getAttribute("result")%></h3> --%>
<!-- <!-- <a href="add2.jsp">이동</a> sendRedirect 온 경우에만 -->
<a href="scope/add2.jsp">이동</a>
</body>
</html>