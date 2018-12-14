<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>세션 주요 정보</h3>
	<ul>
		<li>세션 ID(유일한 식별자) : <%=session.getId()%></li>
		<li>세션 유지시간 : <%=session.getMaxInactiveInterval() %></li>
		<%
			long millsecond=session.getCreationTime();
			Date time=new Date(millsecond);
		%>
		<li>세션 생성시간(1970/01/01이후) : <%=millsecond%></li>
		<%
			SimpleDateFormat format=new SimpleDateFormat("yyyy.MM.dd a h:mm:ss");
		%>
		<li>세션 생성시간(알기쉽게) : <%=format.format(time) %>		
	</ul>
</body>
</html>





