
<%@page import="vo.GoodsVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.GoodsDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	GoodsDAO dao=new GoodsDAO();
	ArrayList<GoodsVO> list=dao.selectAll();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서목록</title>
</head>
<body>
	<table>
		<tr>
			<td>코드</td>
			<td>제목</td>
			<td>저자</td>
			<td>가격</td>			
		</tr>
<%		for(GoodsVO vo:list){ %>		
		<tr>
			<td><%=vo.getCode() %></td>
			<td><%=vo.getTitle() %></td>
			<td><%=vo.getWriter() %></td>
			<td><%=vo.getPrice()%></td>		
		</tr>
	<%} %>
	<tr>
		<td colspan='4'>
			<input type="button" value="도서 입력" onclick="location.href='goods_insert.html'">
			<input type="button" value="도서 삭제" onclick="location.href='goods_delete.html'">
			<input type="button" value="도서 수정" onclick="location.href='goods_modify.html'">
		</td>
	</tr>
	</table>
</body>
</html>














