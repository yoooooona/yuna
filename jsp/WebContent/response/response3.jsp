<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	//response2.html -> response2.jsp -> response3.jsp
    	request.setCharacterEncoding("utf-8");
    	out.print("<h3>"+request.getParameter("name")+"</h3>");
    	//주소줄 : http://localhost:8081/jsp/response/response2.jsp
    	//보는 페이지 : response3.jsp
    %>
	