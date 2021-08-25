function getStringFormBan()
{
    // ajax-запрос к серверу
    $.ajax({
        url : 'admin',  // сервлет
        success : function(response) {
           if(response==="admin") {
                $('#admin_panel').load("formadmin.html");
            }
        }
    });
}