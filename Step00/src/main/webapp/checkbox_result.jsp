<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- hobby 받은 데이터를 전부 출력 -->
	<%
		String[] hobby = request.getParameterValues("hobby");
		for(String str : hobby){
		%>
		
		<p><%=str %></p>		
		
		<%
		}
	%>
</body>
</html>