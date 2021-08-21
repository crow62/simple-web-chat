function getStringUsers()
{
    // ajax-запрос к серверу
    $.ajax({
        url : 'chat',  // сервлет
        success : function(response) {
            // обработка ответа
            $('#users').text(response);
            setTimeout(getStringUsers, 1000);
        }
    });

}
