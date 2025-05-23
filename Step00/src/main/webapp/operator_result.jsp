<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- n1, n2, op 값 받아서 해당 연산결과를 출력 -->
	<%
		String op = request.getParameter("op");
		int n1 = Integer.parseInt(request.getParameter("n1"));
		int n2 = Integer.parseInt(request.getParameter("n2"));
		
		int result = 0;
		
		switch(op){
		case "+":
			result = n1 + n2;
			break;
		case "-":
			result = n1 - n2;
			break;
		case "*":
			result = n1 * n2;
			break;
		case "/":
			result = n1 / n2;
			break;
		case "%":
			result = n1 % n2;
			break;
		}
	%>
	<p><%=n1 %> <%=op %> <%=n2 %> = <%=result %></p>
</body>
</html>








