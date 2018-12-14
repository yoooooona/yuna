<%@page import="vo.GoodsVO"%>
<%@page import="dao.GoodsDAO"%>
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
		out.print("<script>alert('입력 성공');");
		out.print("location.href='book_select_result.jsp';</script>");
	}else{		
		out.print("<script>history.back()</script>");
	}
%>














</html>