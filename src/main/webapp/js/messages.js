function getStringMessages()
{
    // ajax-запрос к серверу
    $.ajax({
        url : 'field',  // сервлет
        success : function(response) {
            $('#mess').text(response);
            setTimeout(getStringMessages, 1500);
        }
    });
}