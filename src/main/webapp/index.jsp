<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Регистрация в чате</title>
</head>
<body>
<h2>Привет! Залогинься и заходи в чат</h2>
<form method="post" action="/chat">
    <label> Введите логин:
        <input type="text" name="login">
        <p>${error}</p>
    </label>
    <button type="submit">Submit</button>
</form>
</body>
</html>
