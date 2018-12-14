<%@page import="member.vo.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	//frontcontroller에서 담아놓은 값 가져오기
    	ArrayList<MemberVO> list=(ArrayList<MemberVO>)request.getAttribute("list");
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Member List</h3>
	<table>
		<tr>
			<td>아이디</td>
			<td>이름</td>
			<td>성별</td>
			<td>이메일</td>
		</tr>
		<% for(MemberVO vo:list){ %>
		<tr>
			<td><%=vo.getUserid() %></td>
			<td><%=vo.getName() %></td>
			<td><%=vo.getGender() %></td>
			<td><%=vo.getEmail() %></td>
		</tr>
		<% }%>
	</table>
</body>
</html>