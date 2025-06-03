<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
/* 테이블 전체 스타일 */
table {
	width: 100%;
	border-collapse: collapse;
	font-family: 'Arial', sans-serif;
	background-color: #fff;
	border-radius: 6px;
	overflow: hidden;
	box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
}

/* 헤더 스타일 */
th {
	background-color: #3b6db3;
	color: white;
	text-align: center;
	padding: 10px;
	font-weight: bold;
	border-right: 1px solid #d3d3d3;
}

/* 마지막 헤더 셀은 border 제거 */
th:last-child {
	border-right: none;
}

/* 데이터 셀 스타일 */
td {
	text-align: center;
	padding: 10px;
	border-top: 1px solid #e0e0e0;
	border-right: 1px solid #f0f0f0;
}

/* 마지막 셀 border 제거 */
td:last-child {
	border-right: none;
}

/* 첫 번째 행 (번호) 숫자 가운데 정렬 */
td:first-child {
	font-weight: bold;
}

/* 빈 행을 위한 높이 확보 */
tr:has(td:empty) td {
	height: 40px;
}

.title {
  text-align: center;
  font-size: 24px;
  font-weight: bold;
  margin-bottom: 20px;
}

</style>
</head>
<body>

	<h2 class="title">전체 사원 목록</h2>
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





