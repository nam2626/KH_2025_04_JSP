<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

		console.log(editor.getMarkdown());
		console.log(editor.getHTML());
	}
</script>
</head>
<body>
	<div class="container">
		<jsp:include page="./template/header.jsp"></jsp:include>
		<hr>
		<form action="./boardWrite.do" method="post" enctype="multipart/form-data">
			<input type="text" name="title" placeholder="제목을 입력하세요">
			<div id="editor"></div>
			<hr>
			<button>글쓰기</button>
			<button type="button" onclick="history.back();">뒤로가기</button>
		</form>
	</div>
</body>
</html>



