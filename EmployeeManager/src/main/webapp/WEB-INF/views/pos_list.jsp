<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>직급 리스트</title>
    <style>
        body {
            font-family: 'Segoe UI', Arial, sans-serif;
            background: #f0f9fa;
            margin: 0;
            padding: 0;
        }
        .table-container {
            max-width: 560px;
            margin: 48px auto;
            background: #fff;
            border-radius: 14px;
            box-shadow: 0 4px 18px rgba(10,130,180,0.07);
            padding: 32px 38px 24px 38px;
        }
        h2 {
            text-align: center;
            color: #0974b3;
            margin-bottom: 28px;
            letter-spacing: 2px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            background: #f7fcfd;
        }
        th, td {
            text-align: center;
            padding: 13px 0;
            font-size: 1.07em;
        }
        th {
            background: #54a5d9;
            color: #fff;
            font-weight: 700;
            border-bottom: 3px solid #0974b3;
        }
        tr:nth-child(even) td {
            background: #eaf4fb;
        }
        tr:nth-child(odd) td {
            background: #f7fcfd;
        }
        td {
            color: #222;
            border-bottom: 1px solid #b4e1f4;
        }
    </style>
</head>
<body>
	<jsp:include page="./template/header.jsp"></jsp:include>

    <div class="table-container">
        <h2>직급 리스트</h2>
        <table>
            <tr>
                <th>직급코드</th>
                <th>직급명</th>
            </tr>
            <c:choose>
                <c:when test="${not empty posList}">
                    <c:forEach var="pos" items="${posList}">
                        <tr>
                            <td>${pos.posNo}</td>
                            <td>${pos.posName}</td>
                        </tr>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <tr>
                        <td colspan="2">등록된 직급이 없습니다.</td>
                    </tr>
                </c:otherwise>
            </c:choose>
        </table>
    </div>
</body>
</html>
