<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1~100까지의 합</title>
</head>
<body>
<%
	//1~100까지 더해서 출력하는 프로그램 작성
	 int sum=0;
	for(int i=0;i<=100;i++){
		sum+=i;
	}
	out.print(sum);
%>

</body>
</html>