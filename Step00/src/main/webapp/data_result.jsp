<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>txt : <%=request.getParameter("txt") %></p>
	<p>today : <%=request.getParameter("today") %></p>
	<p>pwd : <%=request.getParameter("pwd") %></p>
	<p>num : <%=request.getParameter("num") %></p>
</body>
</html>