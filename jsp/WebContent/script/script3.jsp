<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
		
		private String str1="jsp";
	%>
	<% //지역 변수이기 때문에 servlet이 호출된다
		String str1="servlet";
	%>
	<%=str1%>
</body>
</html>