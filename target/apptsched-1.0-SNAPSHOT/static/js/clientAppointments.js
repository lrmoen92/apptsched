
function buildTable(){

    $.ajax({url: '/api/user/', async: 'true', dataType: 'text', type: 'get', success: function(data){
        console.log(data);
        $.ajax({url: '/api/appointment/', aysnc: 'true', success: function(data2){
            $.each(data2, function(idx, appt){
                console.log(appt);
                if(appt.client.emailAddress == data && appt.completed == false)
                {
                    $('#clientAppointment-table').find('tbody')
                        .append($('<tr>')
                            .append($('<td>').text(appt.id))
                            .append($('<td>').text(appt.type))
                            .append($('<td>').text(appt.date))
                            .append($('<td>').text(appt.roomNumber))
                            .append($('<td>').text(appt.employee.firstName + " " + appt.employee.lastName))
                            .append($('<td>').text(appt.client.firstName + " " + appt.client.lastName))
                        )
                }
            })
        }})
    }});
}