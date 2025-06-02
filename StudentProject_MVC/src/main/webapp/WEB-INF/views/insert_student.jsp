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
	<!-- 학번, 이름, 학과명, 성별, 평점 입력받는 폼-->
	<form action="${pageContext.request.contextPath }/insertStudent.do" method="post">
		<input type="text" name="sno" placeholder="학번을 입력하세요"><br>
		<input type="text" name="sname" placeholder="이름을 입력하세요"><br>
		<select name="mno">
			<option value="-">-- 학과 선택 --</option>
			<!-- jstl로 학과 목록을 출력 -->
			<c:forEach var="m" items="${majorList }">
				<option value="${m.mno }">${m.mname }</option>
			</c:forEach>
		</select><br>
		<input type="radio" name="gender" id="g1" value="M" checked><label for="g1">남</label>
		<input type="radio" name="gender" id="g2" value="F"><label for="g2">여</label>
		<br>
		<input type="text" name="score" placeholder="평점을 입력하세요"><br>
		<button type="submit">등록하기</button>
		<button type="reset">초기화</button>
		<button type="button">뒤로가기</button>
	</form>
</body>
</html>







