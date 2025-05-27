<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="1">
		<!-- step이 없으면, 기본값 1 -->
		<c:forEach var="i" begin="1" end="${rows }">
			<tr>
				<c:forEach var="j" begin="1" end="${cols }">
					<td>${i }행 ${j }열</td>
				</c:forEach>
			</tr>				
		</c:forEach>
	</table>
</body>
</html>






