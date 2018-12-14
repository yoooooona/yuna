<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%! //필드나 메소드로 선언됨
		int sum(int a,int b){
		return a+b;
		}
	%>
	<%   //_jspService() 메소드 안에 선언되기 때문에
		// 메소드 선언 불가
		/* int add(int a, int b){
		return a+b;
	} */
		int result=sum(5,6);
		out.print("<h3>"+result+"</h3>");
	%>
	<%-- <h1><%=result%></h1> --%>
</body>
</html>