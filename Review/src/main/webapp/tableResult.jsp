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
		int rows = (int)request.getAttribute("rows");
		int cols = (int)request.getAttribute("cols");
	%>
	<table border="1">
		<%
			for(int i=1;i<=rows;i++){
				%>
					<tr>
				<%
					for(int j=1;j<=cols;j++){
						%>
							<td><%=i %>행 <%=j %>열</td>
						<%
					}
				%>
					</tr>				
				<% 
			}
		%>	
	</table>
</body>
</html>






