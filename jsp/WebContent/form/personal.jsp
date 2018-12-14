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
	request.setCharacterEncoding("utf-8");
	String name=request.getParameter("name");
	String id=request.getParameter("id");
	String email=request.getParameter("email");	
	String job=request.getParameter("job");
	String hobby[]=request.getParameterValues("hobby");
%>

<h3>
	이름 : <%=name%>
</h3>
<h3>
	아이디 : <%=id%>
</h3>
<h3>
	이메일 : <%=email%>
</h3>
<h3>
	직업 : <%=job%>
</h3>
<h3>
	취미 :
	<%
		for(String s:hobby)
			out.print(s+"  ");
	%> 
</h3>

</body>
</html>