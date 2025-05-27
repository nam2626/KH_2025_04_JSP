<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 	<h3>제목 : <%=request.getAttribute("postTitle") %></h3> --%>
	<h3>제목 : ${postTitle}</h3>
	<hr>
	<%-- <p><%=request.getAttribute("postContent") %></p> --%>
	<p>${postContent}</p>
</body>
</html>