<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>부서 리스트</title>
    <style>
        body {
            font-family: 'Segoe UI', Arial, sans-serif;
            background: #f6fef5;
            margin: 0;
            padding: 0;
        }
        .table-container {
            max-width: 560px;
            margin: 48px auto;
            background: #fff;
            border-radius: 14px;
            box-shadow: 0 4px 18px rgba(70, 150, 70, 0.08);
            padding: 32px 38px 24px 38px;
        }
        h2 {
            text-align: center;
            color: #218839;
            margin-bottom: 28px;
            letter-spacing: 2px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            background: #f2fcf3;
        }
        th, td {
            text-align: center;
            padding: 13px 0;
            font-size: 1.07em;
        }
        th {
            background: #79d183;
            color: #fff;
            font-weight: 700;
            border-bottom: 3px solid #218839;
        }
        tr:nth-child(even) td {
            background: #e6fbe7;
        }
        tr:nth-child(odd) td {
            background: #f2fcf3;
        }
        td {
            color: #222;
            border-bottom: 1px solid #b5eacb;
        }
    </style>
</head>
<body>
	<jsp:include page="./template/header.jsp"></jsp:include>

    <div class="table-container">
        <h2>부서 리스트</h2>
        <table>
            <tr>
                <th>부서코드</th>
                <th>부서명</th>
            </tr>
            <c:choose>
                <c:when test="${not empty deptList}">
                    <c:forEach var="dept" items="${deptList}">
                        <tr>
                            <td>${dept.deptNo}</td>
                            <td>${dept.deptName}</td>
                        </tr>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <tr>
                        <td colspan="2">등록된 부서가 없습니다.</td>
                    </tr>
                </c:otherwise>
            </c:choose>
        </table>
    </div>
</body>
</html>
