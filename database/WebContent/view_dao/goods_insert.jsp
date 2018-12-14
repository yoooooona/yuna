
<%@page import="vo.GoodsVO"%>
<%@page import="dao.GoodsDAO"%>
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
	
	GoodsDAO dao=new GoodsDAO();
	GoodsVO vo=new GoodsVO();
	vo.setCode(code);
	vo.setTitle(title);
	vo.setWriter(writer);
	vo.setPrice(price);	
	int result=dao.goods_insert(vo);
	
	if(result>0){
		out.print("입력 성공");
		out.print("<a href='goods_select.jsp'>목록으로</a>");
	}else{
		out.print("입력 실패");
		out.print("<a href='goods_insert.html'>입력화면</a>");
	}
%>














</html>