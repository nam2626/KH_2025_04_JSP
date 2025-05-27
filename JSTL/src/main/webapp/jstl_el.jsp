<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>EL(Expression Language)</h2>
	<p>jsp에서 데이터를 쉽고 간결하게 접근하기 위해 사용하는 스크립트 언어</p>
	<p>request 영역에 저장된 내용은 requestScope를 사용해서 뽑음</p>
	<p>age : ${requestScope.age }</p>
	<p>session 영역에 저장된 내용은 sessionScope를 사용해서 뽑음</p>
	<p>msg : ${sessionScope.msg }</p>
	<!-- dto에 저장된 필드도 하나씩 뽑기, getBoardMemberId() -->
	<ul>
		<li>${sessionScope.dto.boardMemberId }</li>
		<li>${sessionScope.dto.boardMemberPasswd }</li>
		<li>${sessionScope.dto.boardMemberName }</li>
		<li>${sessionScope.dto.boardMemberNick}</li>
	</ul>
</body>
</html>




