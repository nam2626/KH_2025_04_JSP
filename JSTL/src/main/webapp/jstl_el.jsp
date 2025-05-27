<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body{
		height: 5000px;
	}
</style>
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
	<!-- 영역(scope) 쓰지 않으면 자동 검색
		page -> request -> session -> application
	 -->
	<p>${msg }</p>
	<hr>
	<h2>jstl(JSP Standard Tag Library)</h2>
	<!-- set : 변수 선언해서 초기화 -->
	<c:set var="num" value="1000"></c:set>
	<c:set var="obj" value="${sessionScope.dto }" scope="request"/>
	<!-- out : 출력 -->
	<p><c:out value="${ num}" default="숫자 없음"></c:out></p>
	<p><c:out value="${ num1}" default="숫자 없음"></c:out></p>
	<p>${requestScope.obj }</p>
	<h3>if문, test에 조건식, 하나의 조건문에만 사용, else if, else가 없음</h3>
	<c:if test="${age >= 20 }">
		<p>성인입니다.</p>
	</c:if>
	<c:if test="${age < 20 }">
		<p>미성년자입니다.</p>
	</c:if>
	<h3>choose, when, otherwise - 여러개의 조건문</h3>
	<c:choose>
		<c:when test="${age >= 20 && age < 30 }">
			<p>20대 입니다.</p>
		</c:when>
		<c:when test="${age >= 30 && age < 40 }">
			<p>30대 입니다.</p>
		</c:when>
		<c:otherwise>
			<!-- 모든 조건이 거짓일때  -->
			<p>40대 이상 입니다.</p>
		</c:otherwise>
	</c:choose>
	<h3>반복문</h3>
	<ul>
		<!-- var : 반복문 제어변수, begin : 시작값, end : 마지막값, step : 증감값 -->
		<c:forEach var="i" begin="1" end="10" step="1">
			<li>${i }</li>
		</c:forEach>
	</ul>
	<ul>
		<c:forEach var="i" begin="1" end="10" step="2" varStatus="status">
			<li>${i }, ${status.current },${status.begin },${status.end },
				${status.first },${status.last },${status.step },${status.count }
				,${status.index }
			</li>
		</c:forEach>
	</ul>
	<!--
		상태변수
			current : 현재 아이템 값
			index : begin-end로 구성했을때는 var 값, items로 가져왔을때는 인덱스 번호
			count : 1부터 순서값 시작
			first : 해당 순서가 첫번째인지 확인
			last : 해당 순서가 마지막인지 확인
			begin : 시작값
			end : 마지막값
			step : 증가값
	-->
	<!-- 리스트 꺼내는 부분 -->
	<ul>
		<c:forEach var="member" items="${list }" varStatus="status">
				<li>${member },${status.index },${status.count }</li>
		</c:forEach>
	</ul>
</body>
</html>














