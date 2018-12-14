<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>세션 테스트  : name : <%=session.getAttribute("name")%>,
					 id : <%=session.getAttribute("id")%></h3>
	<input type="button" onclick="location.href='sessionSet.jsp'" value="세션 값 저장">
	<input type="button" onclick="location.href='sessionDel.jsp'" value="세션 값 삭제">
	<input type="button" onclick="location.href='sessionInv.jsp'" value="세션 값 초기화">
</body>
</html>



