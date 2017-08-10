function register(){
    var first = $('#first').val();
    var last = $('#last').val();
    var username = $('#username').val();
    var password = $('#password').val();
    var confirmPassword = $('#confirmPassword').val();

    var user = {
        firstName: first,
        lastName: last,
        username: username,
        password: password,
        confirmPassword: confirmPassword
    };

    $.ajax({
        url: '/api/register/',
        async: 'true',
        dataType: 'json',
        data: user,
        type: 'post',
        contentType: 'application/json',
        success: function(data) {
            window.location.reload();
        }
    })

}