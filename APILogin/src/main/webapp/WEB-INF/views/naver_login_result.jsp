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
	<c:if test="${sessionScope.user != null}">
		<p>${sessionScope.user}</p>
		<p><a href="./naver/profile">사용자 정보 읽기</a></p>
		<p><a href="./naver/refresh">토큰 재발급</a></p>
		<p><a href="./naver/delete">토큰 삭제</a></p>
		<p><a href="./naver/logout">로그아웃</a></p>
		<c:if test="${userInfo != null}">${userInfo}</c:if>
	</c:if>>
</body>
</html>