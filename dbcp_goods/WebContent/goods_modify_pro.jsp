<%@page import="vo.GoodsVO"%>
<%@page import="dao.GoodsDAO"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//goods_modify.html 에서 넘긴 값 가져오기
	String code=request.getParameter("code");
	int price=Integer.parseInt(request.getParameter("price"));
	
	GoodsDAO dao=new GoodsDAO();
	GoodsVO vo=new GoodsVO();
	vo.setCode(code);
	vo.setPrice(price);
	int result=dao.goods_modify(vo);

	if(result>0){		
%>
		<script>
			location.href="book_select.jsp";
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














