<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int result = (int)request.getAttribute("result");
	%>
	<p>보내신 정수의 제곱 : <%=result %></p>
</body>
</html>