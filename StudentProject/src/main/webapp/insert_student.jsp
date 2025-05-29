<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="./template/header.jsp"></jsp:include>
	<!-- 학번, 이름, 학과명, 성별, 평점 입력받는 폼-->
	<form action="" method="post">
		<input type="text" name="sno" placeholder="학번을 입력하세요"><br>
		<input type="text" name="sname" placeholder="이름을 입력하세요"><br>
		<select name="mno">
			<option value="-">-- 학과 선택 --</option>
			<!-- jstl로 학과 목록을 출력 -->
		</select><br>
		<input type="radio" name="gender" id="g1" value="M"><label for="g1">남</label>
		<input type="radio" name="gender" id="g2" value="F"><label for="g2">여</label>
		<br>
		<input type="text" name="score" placeholder="평점을 입력하세요"><br>
		<button>등록하기</button>
	</form>
</body>
</html>







