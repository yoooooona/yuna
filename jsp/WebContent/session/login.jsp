<%@page import="test.LoginVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	LoginVO login=(LoginVO)session.getAttribute("login");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%if(login==null){ %>
	<form action="login_result.jsp" method="post">
		<p>아이디 : <input type="text" name="id"></p>
		<p>비밀번호 : <input type="password" name="pwd"></p>
		<p><input type="submit" value="전송"></p>		
	</form>
	<%}else{ 
		out.print(login.getId()+" 님 반갑습니다.");	
		out.print("<input type='button' value='로그아웃' onclick=location.href='logout.jsp'>");	
	  }	
	%>	
</body>
</html>










