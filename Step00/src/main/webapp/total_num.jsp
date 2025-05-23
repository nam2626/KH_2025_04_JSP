<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//사용자가 보낸 num을 아래에 있는 int num에 저장,
		//단 사용자 num 데이터를 안보냈을때는 0을 저장
		int num = 0;
		//1. request로부터 num을 읽어옴
		String n = request.getParameter("num");
		//2. 읽어온 데이터가 숫자인지 판단 해서 숫자면 변환해서 num에 저장
		if(!n.equals("")){
			num = Integer.parseInt(n);
		}
		//데이터 확인
		//	System.out.println(num);
		int sum = 0;
		for(int i=1;i<=num;i++){
			sum += i;		
	%>
			<p><%=i %></p>
			<hr>
	<%
		}
	%>
	<!-- 총합 : ???? -->
		<p><%=sum %></p>
</body>
</html>





