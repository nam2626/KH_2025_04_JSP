<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>새 탭</title>
	</head>
	<body>
		<h1>제목 영역 태그 - 1</h1>
		<h2>제목 영역 태그 - 2</h2>
		<h3>제목 영역 태그 - 3</h3>
		<h4>제목 영역 태그 - 4</h4>
		<h5>제목 영역 태그 - 5</h5>
		<p>문단 태그 - 1</p>
		<p>문단 태그 - 2</p>
		<p>문단 태그 - 3</p>
		<p>
			안녕하세요 <br>
			내 첫번째 웹 페이지 입니다.<br>
			ㅋㅋㅋㅋㅋㅋ
		</p>
		<hr>
		<h2>jsp 기본 문법</h2>
		<!-- 선언문(Declaration) : 필드 및 메서드 작성  -->
		<%!
			//필드
			String message = "Hello World";
			//메서드
			public String getMessage(){
				return message;
			}
		%>	
		
		<!-- 표현식(Expression) : html에 원하는 곳에 자바 데이터를 출력하는 표현식 -->
		<p>선언문 필드 테스트 : <%=message %></p>	
		<p>선언문 메서드 테스트 : <%=getMessage() %></p>	

		<!-- 
			스크립트릿(Scriptlet) : 사용자가 서버에 데이터를 전달하면 실제로 jsp에서 
								  사용자가 보낸 데이터를 받아서 일하는 코드 
		 -->		
		<%
			String msg = request.getParameter("msg");
			String age = request.getParameter("age");
		%>
		<p>스크립트릿 테스트 : <%=msg %></p>
		<p>스크립트릿 테스트 : <%=age %></p>
		<p>하이퍼 링크태그 : <a href="http://localhost:8888/Step00/00_base_statement.jsp?msg=%EC%96%B4%EC%9D%B4&age=100">현재 페이지 이동</a>
	</body>
</html>


















