<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	//goods_insert.html에서 form안에 들어있는 값 가져오기
	String code=request.getParameter("code");
	String title=request.getParameter("title");
	String writer=request.getParameter("writer");
	int price=Integer.parseInt(request.getParameter("price"));
	
	//DB연동
	//클래스 드라이버 로드
	Class.forName("com.mysql.jdbc.Driver");
	//DB 커넥션 얻어오기
	String url="jdbc:mysql://localhost:3306/javadb?useSSL=true";
	Connection con=DriverManager.getConnection(url,"root","12345");
	String sql="insert into goodsinfo values(?,?,?,?)";
	PreparedStatement pstmt=con.prepareStatement(sql);
	pstmt.setString(1, code);
	pstmt.setString(2, title);
	pstmt.setString(3, writer);
	pstmt.setInt(4, price);
	int result=pstmt.executeUpdate();
	if(result>0){
		out.print("입력 성공");
		out.print("<a href='goods_select.jsp'>목록으로</a>");
	}else{
		out.print("입력 실패");
		out.print("<a href='goods_insert.html'>입력화면</a>");
	}
%>














</html>