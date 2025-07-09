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
	<div class="container">
		<jsp:include page="./template/header.jsp"/>
		<hr>
		<h3>제목 : ${board.title }</h3>
		<p>작성자 : ${board.nickName }, 작성일 : ${board.writeDate }</p>
		<p>조회수 : ${board.boardCount}, 좋아요 : ${board.boardLike }, 
		싫어요 : ${board.boardHate }</p>
		<div class="content">
			${board.content }
		</div>
		<div>
			<c:forEach var="file" items="${flist }">
				<a href="./fileDown.do?fno=${file.fno }">${file.fileName }</a><br>
			</c:forEach>
		</div>
		<div>
			<a href="javascript:history.back();">뒤로가기</a>
			
			<c:if test="${sessionScope.user != null && sessionScope.user.id == board.id }">
				<a href="">게시글 삭제</a>
				<a href="">게시글 수정</a>
			</c:if>
		</div>
		<!-- 댓글 출력 , 최근 댓글 5개씩 조회 -->		
	</div>
</body>
</html>







