<%@page import="domain.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
		ProductVO vo=(ProductVO)request.getAttribute("vo");
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="" method="post">
		<table>
			<tr>
				<td>상품코드</td>
				<td><input type="text" name="prcode" required="required" value="<%=vo.getPrcode() %>" readonly="readonly"></td>
			</tr>
			<tr>
				<td>상품명</td>
				<td><input type="text" name="prname" required="required" value="<%=vo.getPrname() %>" readonly="readonly"></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><input type="text" name="price" required="required"></td>
			</tr>
			<tr>
				<td>제조사</td>
				<td><input type="text" name="manufacture" required="required" value="<%=vo.getManufacture() %>" readonly="readonly"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="수정" onclick="location.href='modify.do'">
					<input type="button" value="삭제" onclick="location.href='delete.do?prcode=<%=vo.getPrcode()%>'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>