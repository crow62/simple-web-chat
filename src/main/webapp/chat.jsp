<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html lang="ru">
<head>
    <meta http-equiv="Content-Type" content="text/html; UTF-8">
    <script src="https://code.jquery.com/jquery-2.2.4.js"
            type="text/javascript"></script>
    <script src="js/users.js" type="text/javascript"></script>
    <script src="js/messages.js" type="text/javascript"></script>
    <script src="js/form.js" type="text/javascript"></script>

    <title>Чат</title>
</head>

<body onload="getStringUsers();getStringMessages(); getStringForm()">
<h2>Самый лучший в мире чат :D</h2>


<p><h3>Welcome, <%= session.getAttribute("login")%></h3></p>


<form method="post" action="/exit">
    <input type="hidden" name="_method" value="delete"/>
    <input name="exit" type="submit" id="ex" value="Выйти из чата"/>
</form>

<div class="wrapper">
    <div class="layer3">
        Cписок онлайн пользователей:
    </div>
</div>

<div class="wrapper">

    <div>
    <textarea class="layer1" id="mess" disabled="disabled">

    </textarea>
    </div>

    <div>
    <textarea class="layer2" id="usrs" disabled="disabled">

    </textarea>
    </div>

</div>

<style>
    .wrapper {
        width: 800px;
    }

    .layer1 {
        background-color: #adcde3; /* Цвет фона слоя */
        padding: 5px; /* Поля вокруг текста */
        float: left; /* Обтекание по правому краю */
        width: 500px; /* Ширина слоя */
        height: 300px; /* Высота поля в пикселах */
        resize: none; /* Запрещаем изменять размер */
        font-size: 14pt;
    }

    .layer2 {
        background-color: #7fee67; /* Цвет фона слоя */
        padding: 5px; /* Поля вокруг текста */
        width: 250px; /* Ширина слоя */
        height: 300px; /* Высота поля в пикселах */
        float: right; /* Обтекание по правому краю */
        resize: none; /* Запрещаем изменять размер */
        /*text-align:right;*/
        font-size: 16pt;
    }

    .layer3 {
        text-align: right;
        font-size: 14pt;
    }

</style>

<p>
    <form method="post" action="/msg">
        <input name="usermsg" type="text" id="usermsg" size="102" />
        <input name="submitmsg" type="submit" id="submitmsg" value="Send" />
    </form>
</p>

<div id="form">

</div>


</body>
</html>