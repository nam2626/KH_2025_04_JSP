<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/board.css">
</head>
<body>
    <div class="board-container">
        <table>
            <thead>
                <tr>
                    <th>글번호</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>작성일</th>
                    <th>조회수</th>
                    <th>좋아요</th>
                    <th>싫어요</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="board" items="${requestScope.list}">
                    <tr>
                        <td>${board.bno}</td>
                        <td>${board.title}</td>
                        <td>${board.nickName}</td>
                        <td>${board.writeDate}</td>
                        <td>${board.boardCount}</td>
                        <td>${board.boardLike}</td>
                        <td>${board.boardHate}</td>
                    </tr>
                </c:forEach>
            </tbody>    
            <tfoot>
            	<tr>
            		<td colspan="7" class="pagging_bar">
           			<!-- 
						페이징 결과 출력
							PaggingVO에 있는 getStartPageOfPageGroup,
							getEndPageOfPageGroup 메서드를 이용해서
							jstl의 forEach를 이용해서 게시판 페이지 번호를 출력
		
							<a href="./boardMain.do?page=번호">번호</a>	
					  -->
					  <c:forEach var="i" begin="${pagging.startPageOfPageGroup }" 
					  								end="${pagging.endPageOfPageGroup }">
            			<a href="./boardMain.do?page=${i }">${i }</a>
					  </c:forEach>
						 <!--
							다음 페이지 그룹으로 이동 
							다음 페이지 그룹이 있을때만 표시
							▶ 를 클릭시 다음 그룹의 첫번째 페이지로 이동
							마지막 페이지 그룹이면 해당 링크가 나오면 안됨 
							
							1번째 페이지 그룹 1 2 3 4
							2번째 페이지 그룹 5 6 7 8
							5번 페이지로 이동
							
							isNextPageGroup getEndPageOfPageGroup
						 -->
						 <c:if test="${pagging.nextPageGroup }">
						 	<a href="./boardMain.do?page=${pagging.endPageOfPageGroup + 1 }">▶</a>      
						 </c:if>
            		</td>
            	</tr>
            </tfoot>
        </table>
    </div>
</body>
</html>
