<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>직급 등록</title>
    <style>
        body {
            font-family: 'Segoe UI', Arial, sans-serif;
            background: #f0f7fd;
            margin: 0;
            padding: 0;
        }
        .container {
            background: #fff;
            max-width: 360px;
            margin: 50px auto;
            border-radius: 14px;
            box-shadow: 0 4px 14px rgba(50, 130, 220, 0.08);
            padding: 32px 32px 24px 32px;
        }
        h2 {
            text-align: center;
            color: #1566a6;
            margin-bottom: 24px;
            letter-spacing: 2px;
        }
        label {
            display: block;
            margin-bottom: 8px;
            color: #555;
            font-weight: 500;
        }
        input[type="text"] {
            width: 100%;
            padding: 10px 12px;
            border: 1px solid #b7d0e4;
            border-radius: 6px;
            box-sizing: border-box;
            font-size: 1em;
            margin-bottom: 15px;
            background: #f7fbff;
        }
        input[type="text"]:focus {
            border-color: #3493d2;
            outline: none;
            background: #eaf5fd;
        }
        button {
            width: 100%;
            padding: 12px 0;
            background: #3493d2;
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
            background: #20618c;
        }
    </style>
</head>
<body>
	<jsp:include page="./template/header.jsp"></jsp:include>

    <div class="container">
        <h2>직급 등록</h2>
        <form action="posInsert.do" method="post">
            <label>직급코드</label>
            <input type="text" name="posNo" required />

            <label>직급명</label>
            <input type="text" name="posName" required />

            <button type="submit">등록</button>
        </form>
    </div>
</body>
</html>
