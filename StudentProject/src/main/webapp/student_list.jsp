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
	<jsp:include page="./template/header.jsp"></jsp:include>
	<h2>학생 정보 리스트</h2>
	<table>
		<tr>
			<th>학번</th>
			<th>이름</th>
			<th>학과명</th>
			<th>평점</th>
			<th>성별</th>
			<th>비고</th>
		</tr>
		<!-- 학번, 이름, 학과명, 평점, 성별, 비고 -->	
		<!-- jstl, el 이용해서 전체 학생정보 출력  -->
		<c:forEach var="std" items="${list }" varStatus="status">
			<tr>
				<td>${std.sno }</td>
				<td>${std.sname }</td>
				<td>${std.mname }</td>
				<td>${std.score }</td>
				<td>${std.gender }</td>
				<td><a href="./delete.do?sno=${std.sno }">삭제</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>




