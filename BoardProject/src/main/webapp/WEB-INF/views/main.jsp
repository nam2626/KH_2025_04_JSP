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
        </table>
    </div>
</body>
</html>
