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




</body>
</html>