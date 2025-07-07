<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<jsp:include page="./template/header.jsp"></jsp:include>
		<hr>
		<form action="./boardWrite.do" method="post" enctype="multipart/form-data">
			<input type="text" name="title" placeholder="제목을 입력하세요">
			<textarea name="content"></textarea>
			<hr>
			<button>글쓰기</button>
			<button type="button" onclick="history.back();">뒤로가기</button>
		</form>
	</div>
</body>
</html>



