<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table {
		width:1200px;
		margin:0 auto;
		border-collapse : collapse;
		table-layout: fixed;
	}
	td, th{
		padding:10px 0px;
		text-align: center;
		border: 1px solid black;
	}
	.passwd{
		overflow: hidden;
		white-space: nowrap;
		text-overflow: ellipsis;
	}
</style>
</head>
<body>
	<table>
		<tr>
			<th>아이디</th>
			<th>암호</th>
			<th>이름</th>
			<th>닉네임</th>
		</tr>
		<c:forEach var="member" items="${requestScope.list }">
			<tr>
				<td>${member.id }</td>
				<td class="passwd">${member.passwd }</td>
				<td>${member.userName }</td>
				<td>${member.nickName }</td>
			</tr>
		</c:forEach>		
	</table>
</body>
</html>








