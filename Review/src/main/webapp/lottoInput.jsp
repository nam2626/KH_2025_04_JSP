<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>로또 번호 생성</title>
</head>
<body>

    <h1>로또 번호 생성</h1>
    <hr>
    <form action="lottoGenerator" method="GET">
        <p>
            <label for="setCount">생성할 로또 셋트 수 (1-10):</label>
            <input type="number" id="setCount" name="setCount" min="1" max="10" value="1" required>
        </p>
        <p>
            <button type="submit">번호 생성</button>
        </p>
    </form>

</body>
</html>
