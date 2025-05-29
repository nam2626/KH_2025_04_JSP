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
	<form action="./updateStudent.do" method="post">
		<input type="text" name="sno" readonly placeholder="학번을 입력하세요" value="${student.sno }"><br>
		<input type="text" name="sname" placeholder="이름을 입력하세요" value="${student.sname }"><br>
		<select name="mno">
			<option value="-">-- 학과 선택 --</option>
			<!-- jstl로 학과 목록을 출력 -->
			<c:forEach var="m" items="${majorList }">
				<option value="${m.mno }" ${m.mno == student.mno ? "selected" : "" }>${m.mname }</option>
			</c:forEach>
		</select><br>
		<input type="radio" name="gender" id="g1" value="M" ${student.gender == "M" ? "checked" : ""}><label for="g1">남</label>
		<input type="radio" name="gender" id="g2" value="F" ${student.gender == "F" ? "checked" : ""}><label for="g2">여</label>
		<br>
		<input type="text" name="score" placeholder="평점을 입력하세요" value="${student.score }"><br>
		<button>수정하기</button>
	</form>
</body>
</html>







