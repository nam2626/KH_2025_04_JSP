<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	/* ajax 호출 결과 출력하는 코드 작성 */
	window.onload = () => {
		document.querySelector('button').onclick = () => {
			let txt = document.querySelector('.txt_search').value;
			let tag = '';
			fetch(`./naver?text=\${txt}`)
			.then(response => response.json())
			.then(data => {
				console.log(data);
				let area = document.querySelector('.area');
				data.items.forEach(obj => {
					let title = document.createElement('h2');
					title.textContent = obj.title;
					area.appendChild(title);
					let a = document.createElement('a');
					a.textContent = '링크 이동';
					a.href = obj.link;
					area.appendChild(a);
					let p = document.createElement('p');
					p.textContent = obj.description;
					area.appendChild(p);
					
				});
			});
		}
	}
</script>
</head>
<body>
	<!-- 검색어 입력 받는 폼 -->
	<input type="text" class="txt_search">
	<button>검색</button>
	<!--  검색 결과 출력하는 영역 -->
	<!-- title, link, description 출력
		link를 클릭하면 해당 웹페이지로 이동하게끔 처리
	 -->
	 <hr>
	 <div class="area"></div>
</body>
</html>




