<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--  이렇게 써주면 Servlet에서 포워드 시키는 방법대로 안해도 됨 
		RequestDispatcher rd=request.getRequestDispatcher("scope/add.jsp");
		rd.forward(request,response);
-->
<jsp:forward page="add2.jsp"/>