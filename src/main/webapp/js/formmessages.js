function getStringFormMessages()
{
    // ajax-запрос к серверу
    $.ajax({
        url : 'ban',  // сервлет
        success : function(response) {
            if(response==="active") {
                $('#user_panel').load("formclient.html");
            }
        }
    });
}