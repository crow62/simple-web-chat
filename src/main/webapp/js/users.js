function getStringUsers()
{
    // ajax-запрос к серверу
    $.ajax({
        url : 'users',  // сервлет
        success : function(response) {
            $('#usrs').text(response);
            setTimeout(getStringUsers, 3500);
        }
    });

}
