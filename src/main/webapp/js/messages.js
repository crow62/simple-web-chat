function getStringMessages()
{
    // ajax-запрос к серверу
    $.ajax({
        url : 'msg',  // сервлет
        success : function(response) {
            $('#mess').text(response);
            setTimeout(getStringMessages, 1500);
        }
    });
}