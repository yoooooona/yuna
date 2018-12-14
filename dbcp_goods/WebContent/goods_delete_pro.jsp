<%@page import="dao.GoodsDAO"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//goods_delete.html 에서 넘긴 값 가져오기
	String code=request.getParameter("code");	
	
	GoodsDAO dao=new GoodsDAO();
	int result=dao.goods_delete(code);
	
	if(result>0){		
%>
		<script>
			location.href="book_select_result.jsp";
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





