<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>사원 등록</title>
    <style>
        body {
            font-family: 'Segoe UI', Arial, sans-serif;
            background: #f5f6fa;
            margin: 0;
            padding: 0;
        }
        .container {
            background: #fff;
            max-width: 400px;
            margin: 40px auto 0 auto;
            border-radius: 12px;
            box-shadow: 0 4px 16px rgba(60,60,60,0.09);
            padding: 32px 32px 24px 32px;
        }
        h2 {
            text-align: center;
            color: #222;
            margin-bottom: 28px;
            letter-spacing: 1px;
        }
        form label {
            display: block;
            margin-bottom: 7px;
            margin-top: 18px;
            color: #666;
            font-weight: 500;
        }
        form input[type="text"],
        form select {
            width: 100%;
            padding: 10px 12px;
            border: 1px solid #ccd6dd;
            border-radius: 6px;
            box-sizing: border-box;
            font-size: 1em;
            margin-bottom: 6px;
            background: #fafbfc;
            transition: border 0.2s;
        }
        form input[type="text"]:focus,
        form select:focus {
            border-color: #4b89dc;
            outline: none;
            background: #f3f6fb;
        }
        form button {
            margin-top: 18px;
            width: 100%;
            padding: 12px 0;
            background: #4b89dc;
            color: #fff;
            font-size: 1.1em;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            transition: background 0.2s;
            font-weight: bold;
            letter-spacing: 1px;
        }
        form button:hover {
            background: #3572b5;
        }
    </style>
</head>
<body>
	<jsp:include page="./template/header.jsp"></jsp:include>

    <div class="container">
        <h2>사원 등록</h2>
        <form action="${pageContext.request.contextPath }/insertEmployee.do" method="post">
            <label>사번</label>
            <input type="text" name="empNo" required />

            <label>이름</label>
            <input type="text" name="name" required />

            <label>부서</label>
            <select name="department" required>
                <option value="">부서 선택</option>
                <c:forEach var="dept" items="${deptList}">
                    <option value="${dept.deptNo}">${dept.deptName}</option>
                </c:forEach>
            </select>

            <label>직급</label>
            <select name="position" required>
                <option value="">직급 선택</option>
                <c:forEach var="pos" items="${posList}">
                    <option value="${pos.posNo}">${pos.posName}</option>
                </c:forEach>
            </select>

            <!-- 예시: 급여와 입사일도 추가 -->
            <label>급여</label>
            <input type="text" name="salary" required />

            <label>입사일</label>
            <input type="text" name="hireDate" placeholder="YYYY-MM-DD" required />

            <button type="submit">등록</button>
        </form>
    </div>
</body>
</html>
