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
	
	<h2>전체 사원 목록</h2>
	<table>
		<tr>
			<th>No</th>
			<th>사번</th>
			<th>이름</th>
			<th>직급</th>
			<th>부서</th>
			<th>급여</th>
			<th>입사일</th>
		</tr>
		<c:forEach var="emp" items="${empList }" varStatus="status">
			<tr>
				<td>${status.count }</td>
				<td>${emp.empNo }</td>
				<td>${emp.empName }</td>
				<td>${emp.posNo }</td>
				<td>${emp.deptNo }</td>
				<td>${emp.salary }</td>
				<td>${emp.hireDate }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>





