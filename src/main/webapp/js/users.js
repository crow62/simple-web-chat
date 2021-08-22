function getStringUsers()
{
    // ajax-запрос к серверу
    $.ajax({
        url : 'chat',  // сервлет
        success : function(response) {
            $('#usrs').text(response);
            setTimeout(getStringUsers, 3500);
        }
    });

}
