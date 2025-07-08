<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://uicdn.toast.com/editor/latest/toastui-editor.min.css" />
<script src="https://uicdn.toast.com/editor/latest/toastui-editor-all.min.js"></script>
<script>
	window.onload = () => {
		const editor = new toastui.Editor({
	        el: document.querySelector('#editor'),
	        previewStyle: 'vertical',
	        height: '500px',
	        initialValue: '이곳에 내용을 입력하세요'
	      });

//		console.log(editor.getMarkdown());
		console.log(editor.getHTML());
		document.querySelector('form').onsubmit = (e) => {
			//e.preventDefault();
			console.log(editor.getHTML());	
			document.querySelector('#content').value = editor.getHTML(); 
		}
	}
</script>
</head>
<body>
	<c:if test="${sessionScope.user == null }">
		<script>
			alert('로그인 하셔야 이용하실 수 있습니다.');
			location.href = './boardMain.do';
		</script>	
	</c:if>
	<div class="container">
		<jsp:include page="./template/header.jsp"></jsp:include>
		<hr>
		<form action="./boardWrite.do" method="post" enctype="multipart/form-data">
			<input type="text" name="title" placeholder="제목을 입력하세요">
			<div id="editor"></div>
			<input type="hidden" name="content" id="content">
			<hr>
			<input type="file" name="file"><br>
			<input type="file" name="file"><br>
			<input type="file" name="file">
			<hr>
			<button>글쓰기</button>
			<button type="button" onclick="history.back();">뒤로가기</button>
		</form>
	</div>
</body>
</html>



