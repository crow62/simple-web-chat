function getStringUsers()
{
    // ajax-запрос к серверу
    $.ajax({
        url : 'chat',  // сервлет
        success : function(response) {
            $('#users').text(response);
            setTimeout(getStringUsers, 2500);
        }
    });

}
