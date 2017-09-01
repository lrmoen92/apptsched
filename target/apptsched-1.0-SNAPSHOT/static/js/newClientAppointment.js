function readyPage(){
    $.ajax({url: '/api/employee/', async: 'true', dataType: 'json', type: 'get', success: function (data){
        $.each(data, function(idx, employee){
            $("#inputEmployee").append('<option value=' + employee.id + '>' + employee.firstName + ' ' + employee.lastName + '</option>')
        })
    }})
}


function saveAppointment(){


        $.ajax({url: '/api/user/', async: 'true', dataType: 'text', type: 'get', success: function(data) {
            $.ajax({url: '/api/client/?email=' + data, async: 'true', dataType: 'json', type: 'get', success: function (data2) {
                $.ajax({url: '/api/employee/'+ $('#inputEmployee').val(), async: 'true', dataType: 'json', type: 'get', success: function (data3) {
                    var id = $('#appointmentId').val();
                    var version = $('#appointmentVersion').val();
                    var type = $('#inputType').val();
                    var date = $('#inputDate').val();
                    var room = $('#inputRoom').val();
                    var employee = data3;
                    var client = data2;
                    console.log(employee);
                    console.log(client);

                    var appointment = {
                        id: id,
                        version: version,
                        type: type,
                        date: date,
                        roomNumber: room,
                        employee: employee,
                        client: client
                    };
                    console.log(appointment);
                    var appointmentString = JSON.stringify(appointment);

                    $.ajax({
                        type: "put",
                        data: appointmentString,
                        url: "/api/appointment/",
                        async: 'true',
                        dataType: 'json',
                        contentType: 'application/json',
                        success: function(){
                            window.location.reload();
                        }
                    })


                }})
            }})
        }});

}