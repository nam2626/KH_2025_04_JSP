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
	<h1>생성된 로또 번호</h1>
	<c:choose>
		<c:when test="${lottoNumbers == null || lottoNumbers.isEmpty() }">
			<p>생성된 로또 번호가 없습니다.</p>
		</c:when>
		<c:otherwise>
			<c:forEach var="list" items="${lottoNumbers }" varStatus="status">
				<p> [${status.count }] : 
					<c:forEach var="num" items="${list }" varStatus="nStatus">
						${ num}
						<c:if test="${!nStatus.last }">, </c:if> 
					</c:forEach>
				</p>
			</c:forEach>
		</c:otherwise>
	</c:choose>
	
</body>
</html>





