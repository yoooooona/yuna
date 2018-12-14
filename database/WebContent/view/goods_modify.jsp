<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//goods_modify.html 에서 넘긴 값 가져오기
	String code=request.getParameter("code");
	int price=Integer.parseInt(request.getParameter("price"));
	
	
	//DB연동
	Class.forName("com.mysql.jdbc.Driver");
	String url="jdbc:mysql://localhost:3306/javadb?useSSL=true";
	Connection con=DriverManager.getConnection(url,"root","12345");
	String sql="update goodsinfo set price=? where code=?";
	PreparedStatement pstmt=con.prepareStatement(sql);
	pstmt.setInt(1, price);
	pstmt.setString(2, code);
	int result=pstmt.executeUpdate();

	if(result>0){		
%>
		<script>
			location.href="goods_select.jsp";
		</script>
<%
	}else{
%>		
		<script>
			alert('코드를 확인해 주세요');
			history.back();
		</script>
<%
	}
%>














