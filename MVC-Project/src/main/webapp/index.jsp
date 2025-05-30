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
	<!-- 로그인이 안되어 있으면 login.jsp로 이동 -->
	<c:if test="${sessionScope.user == null }">
		<c:redirect url="./loginView.do"></c:redirect>
	</c:if>
	<a href="">로그인</a>
	<a href="">전체 회원정보 조회</a>
	<a href="">회원 가입 처리</a>
</body>
</html>