function register(){
    var first = $('#first').val();
    var last = $('#last').val();
    var username = $('#username').val();
    var password = $('#password').val();
    var confirmPassword = $('#confirmPassword').val();

    var userDto = {
        firstName: first,
        lastName: last,
        username: username,
        password: password,
        confirmPassword: confirmPassword
    };

    console.log(userDto);

    var userString = JSON.stringify(userDto);

    $.ajax({
        type: "put",
        data: userString,
        url: "/api/register/",
        async: 'true',
        dataType: 'json',
        contentType: 'application/json',
        success: function() {
            window.location.reload();
        }
    })

}