<%@ page language="java" import="java.sql.*" contentType="text/html; charset=UTF-8"%>
<%
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url = "jdbc:oracle:thin:@localhost:1522:seven";
	Connection dbconn = DriverManager.getConnection(url, "madang", "madang");
	Statement stmt = dbconn.createStatement();
	ResultSet myResultSet = stmt.executeQuery("SELECT * FROM book");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>***BOOK LIST***</title>
</head>
<body bgcolor="white" text="black" link="blue" vlink="purple"
	alink="red">
	<table border="1" cellspacing="0" width="400" borderscolor="#9AD2F7"
		bordercolordark="white" bordercolorlight="#D2E9F9">
		<tr>
			<td width="150" height="20" bgcolor="#D2E9F9">
				<p align="center">
					<span style="font-size: 8pt;"><b>BOOKNAME</b></span>
				</p>
			</td>
			<td width="150" height="20" bgcolor="#D2E9F9">
				<p align="center">
					<span style="font-size: 8pt;"><b>PUBLISHER</b></span>
				</p>
			</td>
			<td width="50" height="20" bgcolor="#D2E9F9">
				<p align="center">
					<span style="font-size: 8pt;"><b>PRICE</b></span>
				</p>
			</td>
		</tr>
		<%
			if (myResultSet != null) {
				while (myResultSet.next()) {
					String W_BOOKID = myResultSet.getString("bookid");
					String W_BOOKNAME = myResultSet.getString("bookname");
					String W_PUBLISHER = myResultSet.getString("publisher");
					String W_PRICE = myResultSet.getString("price");
		%>
		<tr>
			<td width="150" height="20">
				<p>
					<span style="font-size: 9pt;"> <a
						href="bookview.jsp?bookid=<%=W_BOOKID%>"> <font face="돋움체"
							color="black"> <%=W_BOOKNAME%></font></a></span>
				</p>
			</td>
			<td width="150" height="20">
				<p align="center">
					<span style="font-size: 9pt;">
					<font face="돋움체"><%=W_PUBLISHER%></font></span>
				</p>
			</td>
			<td width="50" height="20">
				<p align="center">
					<span style="font-size: 9pt;">
					<font face="돋움체"><%=W_PRICE%></font></span>
				</p>
			</td>
		</tr>
		<%
			}
			}
			stmt.close();
			dbconn.close();
		%>
	</table>
	<table cellpadding="0" cellspacing="0" width="400" height="23">
		<tr>
			<td width="1350">
				<p align="right">
					<b><a href="booklist.jsp"> <font size="1" face="돋움체"
							color="black">LIST</font></a></b>
				</p>
			</td>
		</tr>
	</table>
</body>
</html>