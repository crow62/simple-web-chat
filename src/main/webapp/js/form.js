function getStringForm()
{
    // ajax-запрос к серверу
    $.ajax({
        url : 'chat',  // сервлет
        success : function(response) {
            let split = response.split("\n");
            if (split[split.length-1]==="Admin") {
                $('#form').load("/form.html");
            }
            //setTimeout(getStringForm, 1000);
        }
    });
}