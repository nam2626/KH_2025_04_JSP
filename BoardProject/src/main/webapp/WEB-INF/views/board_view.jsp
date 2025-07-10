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
		<hr>	
		<!-- 댓글 출력 , 최근 댓글 5개씩 조회 -->
		<div>
			<!-- 
				댓글 추가 폼 
				댓글 내용, 글번호
			-->
			<c:if test="${sessionScope.user != null }">
				<form action="./boardCommentInsert.do" method="post">
					<textarea name="content" placeholder="댓글 내용을 입력해 주세요"></textarea>
					<button>등록</button>
					<input type="hidden" name="bno" value="${board.bno }">
				</form>
			</c:if>
			<!-- 
				댓글 번호(보이지 않음), 작성자, 작성일, 좋아요, 싫어요, 댓글 내용
				로그인한 아이디가 작성자와 동일하면 댓글 삭제, 댓글 수정 버튼 	
			-->
			<c:forEach var="comment" items="${clist }">
				<div class="comment">
					<input type="hidden" name="cno" value="cno">
					<ul>
						<li>작성자 : ${comment.nickName }</li>
						<li>작성일 : ${comment.cdate }</li>	
						<li>좋아요 : ${comment.clike }</li>
						<li>싫어요 : ${comment.chate }</li>
					</ul>
					<p>${comment.content }</p>
					<div>
						<c:if test="${sessionScope.user.id == comment.id }">
							<a href="./boardCommentDelete.do?cno=${comment.cno }">댓글 삭제</a>
							<a>댓글 수정</a>
						</c:if>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>







