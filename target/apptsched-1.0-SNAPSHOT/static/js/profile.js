function buildPage(){
    $.ajax(
        {
            url: "/api/user/",
            async: "true",
            dataType: "text",
            type: "get",


            success: function(userData) {

                if(userData.substring(userData.indexOf('@')) === "@astontech.com"){
                   $.ajax(
                       {
                           url: "/api/employee/",
                           async: "true",
                           dataType: "json",
                           type:  "get",
                           success: function(employeeData){
                               $.each(employeeData, function(idx, employee) {
                                   if (employee.emailAddress === userData) {
                                           $('#id').val(employee.id);
                                           $('#version').val(employee.version);
                                            $('#usernameDiv').append($('<input id=username class=form-control placeholder=' + employee.emailAddress + '>'));
                                            $('#passwordDiv').append($('<input id=password class=form-control>'));
                                            $('#confirmPasswordDiv').append($('<input id=confirmPassword class=form-control>'));
                                            $('#firstDiv').append($('<input id=first class=form-control placeholder=' + employee.firstName + '>'));
                                            $('#middleDiv').append($('<input id=middle class=form-control placeholder=' + employee.middleName + '>'));
                                            $('#lastDiv').append($('<input id=last class=form-control placeholder=' + employee.lastName + '>'));
                                            $('#phoneNumberDiv').append($('<input id=phoneNumber class=form-control placeholder=' + employee.phoneNumber + '>'));
                                       }
                                   }
                               )
                           }
                       }
                   )
                }else{
                    $.ajax(
                        {
                            url: "/api/client/",
                            async: "true",
                            dataType: "json",
                            type:  "get",
                            success: function(clientData){
                                $.each(clientData, function(idx, client) {
                                    if (client.emailAddress === userData) {
                                        $('#id').val(client.id);
                                        $('#version').val(client.version);
                                        $('#usernameDiv').append($('<input id=username class=form-control value=' + client.emailAddress + '>'));
                                        $('#passwordDiv').append($('<input id=password type=password class=form-control>'));
                                        $('#confirmPasswordDiv').append($('<input id=confirmPassword type=password class=form-control>'));
                                        $('#firstDiv').append($('<input id=first class=form-control value=' + client.firstName + '>'));
                                        $('#middleDiv').append($('<input id=middle class=form-control value=' + client.middleName + '>'));
                                        $('#lastDiv').append($('<input id=last class=form-control value=' + client.lastName + '>'));
                                        $('#phoneNumberDiv').append($('<input id=phoneNumber class=form-control value=' + client.phoneNumber + '>'));
                                        }
                                    }
                                )
                            }
                        }
                    )
                }
            }


        }
    )
}

function savePerson(){

    var person = {

        id: $('#id').val(),
        version: $('#version').val(),
        emailAddress: $('#username').val(),
        firstName: $('#first').val(),
        middleName: $('#middle').val(),
        lastName: $('#last').val(),
        password: $('#password').val(),
        phoneNumber: $('#phoneNumber').val()

    };

    console.log(person);

    var personString = JSON.stringify(person);


    $.ajax(
        {
            type: "put",
            data: personString,
            url: "/api/person/",
            async: 'true',
            dataType: 'json',
            contentType: 'application/json',
            success: function(){
                window.location.reload();
            }
        })
}