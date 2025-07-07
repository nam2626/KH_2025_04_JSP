<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
/* nav 바 전체 스타일 */
nav {
	background-color: #333; /* 어두운 배경색 */
	padding: 10px 0; /* 위아래 패딩 */
	font-family: Arial, sans-serif; /* 폰트 설정 */
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2); /* 그림자 효과로 입체감 부여 */
}

/* ul (unordered list) 스타일 */
nav ul {
	list-style-type: none; /* 목록 마커 제거 */
	margin: 0; /* 기본 마진 제거 */
	padding: 0; /* 기본 패딩 제거 */
	display: flex; /* Flexbox를 사용하여 가로로 정렬 */
	justify-content: center; /* 항목들을 가운데 정렬 */
	align-items: center; /* 세로 가운데 정렬 */
}

/* li (list item) 스타일 */
nav ul li {
	margin: 0 15px; /* 각 항목 사이의 간격 */
}

/* a (anchor) 링크 스타일 */
nav ul li a {
	display: block; /* 링크 영역을 블록으로 만들어 클릭 영역 확장 */
	color: #f2f2f2; /* 밝은 글자색 */
	text-align: center; /* 텍스트 가운데 정렬 */
	padding: 10px 15px; /* 링크 내부 패딩 */
	text-decoration: none; /* 밑줄 제거 */
	transition: background-color 0.3s ease, color 0.3s ease;
	/* 호버 시 부드러운 전환 효과 */
	border-radius: 5px; /* 약간 둥근 모서리 */
}

/* 마우스 호버 시 링크 스타일 */
nav ul li a:hover {
	background-color: #575757; /* 호버 시 배경색 변경 */
	color: #fff; /* 호버 시 글자색 유지 또는 변경 (흰색으로 고정) */
}

/* (선택 사항) 현재 페이지를 나타내는 active 클래스 스타일 */
/* 예를 들어, '홈'이 현재 페이지면 <li class="active"><a href="...">홈</a></li> */
/* 또는 <a class="active" href="...">홈</a> 처럼 사용 가능 */
nav ul li a.active {
	background-color: #007bff; /* 활성 항목의 배경색 (파란색 계열) */
	color: white; /* 활성 항목의 글자색 */
	font-weight: bold; /* 활성 항목 글자 두껍게 */
}
</style>
<nav>
	<ul>
		<li><a href="./boardMain.do">홈</a></li>
		<li><a href="./boardWriteView.do">글쓰기</a></li>
		<li><a href="./loginView.do">로그인</a></li>
		<li><a href="./registerView.do">회원가입</a></li>
	</ul>
</nav>





