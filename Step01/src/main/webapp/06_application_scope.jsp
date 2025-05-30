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
		int count = application.getAttribute("count") == null ? 0 : (int)application.getAttribute("count");
		application.setAttribute("count", count + 1);
	
	%>
	<p>어플리케이션 영역 : ${applicationScope.count }</p>
	<p><a href="./applicationServlet">application 영역 테스트</a></p>
</body>
</html>