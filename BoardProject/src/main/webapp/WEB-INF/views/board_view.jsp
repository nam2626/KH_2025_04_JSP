<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./resources/css/board_detail.css"> 
</head>
<body>
	<div class="board-container"> <%-- 최상위 div에 board.css의 .board-container 클래스 적용 --%>
		<jsp:include page="./template/header.jsp"/>
		<hr>
		<h3 class="board-title">제목 : ${board.title }</h3> <%-- 제목에 클래스 적용 --%>
		<p class="board-meta-info">작성자 : ${board.nickName }, 작성일 : ${board.writeDate }</p> <%-- 메타 정보에 클래스 적용 --%>
		<p class="board-meta-info">조회수 : ${board.boardCount}, 좋아요 : ${board.boardLike }, 
		싫어요 : ${board.boardHate }</p> <%-- 메타 정보에 클래스 적용 --%>
		<div class="content">
			${board.content }
		</div>
		<div class="file-downloads"> <%-- 파일 다운로드 링크들을 묶는 div에 클래스 추가 --%>
			<c:forEach var="file" items="${flist }">
				<a href="./fileDown.do?fno=${file.fno }">${file.fileName }</a><br>
			</c:forEach>
		</div>
		<div class="board-actions"> <%-- 게시글 액션 버튼들을 묶는 div에 클래스 추가 --%>
			<a href="javascript:history.back();" class="button-common">뒤로가기</a>
			
			<c:if test="${sessionScope.user != null && sessionScope.user.id == board.id }">
				<a href="" class="button-common button-delete">게시글 삭제</a> <%-- 버튼 클래스 적용 --%>
				<a href="" class="button-common button-modify">게시글 수정</a> <%-- 버튼 클래스 적용 --%>
			</c:if>
		</div>
		<hr>	
		<!-- 댓글 출력 , 최근 댓글 5개씩 조회 -->
		<div class="comments-section"> <%-- 댓글 섹션 전체를 묶는 클래스 추가 --%>
			<!-- 
				댓글 추가 폼 
				댓글 내용, 글번호
			-->
			<c:if test="${sessionScope.user != null }">
				<form action="./boardCommentInsert.do" method="post" class="comment-form">
					<textarea name="content" placeholder="댓글 내용을 입력해 주세요"></textarea>
					<button type="submit" class="button-common button-register">등록</button> <%-- 버튼 클래스 적용 --%>
					<input type="hidden" name="bno" value="${board.bno }">
				</form>
			</c:if>
			<!-- 
				댓글 번호(보이지 않음), 작성자, 작성일, 좋아요, 싫어요, 댓글 내용
				로그인한 아이디가 작성자와 동일하면 댓글 삭제, 댓글 수정 버튼 	
			-->
			<c:forEach var="comment" items="${clist }">
				<div class="comment">
					<input type="hidden" name="cno" value="${comment.cno}"> <%-- value="cno"를 실제 값으로 변경 --%>
					<ul>
						<li>작성자 : ${comment.nickName }</li>
						<li>작성일 : ${comment.cdate }</li>	
						<li>좋아요 : ${comment.clike }</li>
						<li>싫어요 : ${comment.chate }</li>
					</ul>
					<p>${comment.content }</p>
					<div class="comment-actions"> <%-- 댓글 액션 버튼들을 묶는 div에 클래스 추가 --%>
						<c:if test="${sessionScope.user.id == comment.id }">
							<a href="./boardCommentDelete.do?cno=${comment.cno }" class="button-common button-delete button-small">댓글 삭제</a> <%-- 버튼 클래스 적용 --%>
							<a href="#" class="button-common button-modify button-small">댓글 수정</a> <%-- 버튼 클래스 적용 --%>
						</c:if>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>