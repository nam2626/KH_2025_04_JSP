<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>부서 등록</title>
    <style>
        body {
            font-family: 'Segoe UI', Arial, sans-serif;
            background: #f8fdf4;
            margin: 0;
            padding: 0;
        }
        .container {
            background: #fff;
            max-width: 360px;
            margin: 50px auto;
            border-radius: 14px;
            box-shadow: 0 4px 14px rgba(70, 180, 70, 0.09);
            padding: 32px 32px 24px 32px;
        }
        h2 {
            text-align: center;
            color: #269e40;
            margin-bottom: 24px;
            letter-spacing: 2px;
        }
        label {
            display: block;
            margin-bottom: 8px;
            color: #444;
            font-weight: 500;
        }
        input[type="text"] {
            width: 100%;
            padding: 10px 12px;
            border: 1px solid #aedbaa;
            border-radius: 6px;
            box-sizing: border-box;
            font-size: 1em;
            margin-bottom: 15px;
            background: #f5fef4;
        }
        input[type="text"]:focus {
            border-color: #54c37e;
            outline: none;
            background: #e6fbe7;
        }
        button {
            width: 100%;
            padding: 12px 0;
            background: #54c37e;
            color: #fff;
            font-size: 1.1em;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            transition: background 0.2s;
            font-weight: bold;
            letter-spacing: 1px;
        }
        button:hover {
            background: #269e40;
        }
    </style>
</head>
<body>
	<jsp:include page="./template/header.jsp"></jsp:include>

    <div class="container">
        <h2>부서 등록</h2>
        <form action="deptInsert.do" method="post">
            <label>부서코드</label>
            <input type="text" name="deptNo" required />

            <label>부서명</label>
            <input type="text" name="deptName" required />

            <button type="submit">등록</button>
        </form>
    </div>
</body>
</html>
