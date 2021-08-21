function getStringMessages()
{
    // ajax-запрос к серверу
    $.ajax({
        url : 'field',  // сервлет
        success : function(response) {
            // обработка ответа
            $('#mess').text(response);
            setTimeout(getStringMessages, 1000);
        }
    });
}