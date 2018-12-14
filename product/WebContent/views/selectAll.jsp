<%@page import="domain.ProductVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	//selectAllAction에서 담은 값 가져오기
    	ArrayList<ProductVO> list=(ArrayList<ProductVO>)request.getAttribute("list");
    	
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<%-- for 리스트 출력하기 --%>
		<table border="1">
		<tr>
		<td>제품 코드</td>
		<td>제품명</td>
		<td>가 격</td>
		<td>제 조 사</td>
		</tr>
		<% for(ProductVO vo:list){ %>
		<tr>
		<td align="center"><a href="select.do?prcode=<%=vo.getPrcode()%>"><%=vo.getPrcode() %></a></td> <!-- 주소 표시줄  -->
		<td><%=vo.getPrname() %></td>
		<td><%=vo.getPrice() %></td>
		<td><%=vo.getManufacture() %></td>
		</tr>
		<%} %>
		
		</table>
</body>
</html>