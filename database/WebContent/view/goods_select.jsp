<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//goodsinfo 테이블 목록 가져오기
	
	
	//드라이버 로드
	Class.forName("com.mysql.jdbc.Driver");
	String url="jdbc:mysql://localhost:3306/javadb?useSSL=true";
	Connection con=DriverManager.getConnection(url, "root", "12345");
	String sql="select * from goodsinfo";
	PreparedStatement pstmt=con.prepareStatement(sql);
	ResultSet rs=pstmt.executeQuery();
	
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
<%		while(rs.next()){ %>		
		<tr>
			<td><%=rs.getString(1) %></td>
			<td><%=rs.getString(2) %></td>
			<td><%=rs.getString(3) %></td>
			<td><%=rs.getInt(4) %></td>		
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














