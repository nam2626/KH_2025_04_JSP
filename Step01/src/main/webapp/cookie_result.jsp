<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>쿠키 정보 확인</h2>
	<%
		Cookie[] cookies = request.getCookies();
		for(int i=0;i<cookies.length;i++){
			%>
				<p><%=cookies[i].getName() %> / <%=cookies[i].getValue() %></p>
			<%
		}
	%>
	
</body>
</html>