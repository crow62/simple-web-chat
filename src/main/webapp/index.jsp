<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Регистрация в чате</title>
</head>
<body>
<h2>Привет! Залогинься и заходи в чат</h2>
<form name="form" method="post" action="chat">
    <label> Введите логин:
        <input type="text" name="login" id="id1" required>
        <p>${error}</p>
    </label>
    <button onclick="validate()" type="submit">Submit</button>
</form>
</body>
</html>
