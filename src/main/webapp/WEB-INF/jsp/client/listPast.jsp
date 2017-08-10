<%@include file="../includes/header.jsp" %>
<%@include file="../includes/navbar.jsp" %>
<script src="/static/js/pastClientAppointments.js">
</script>
<script>
    $(document).ready(function() {
        buildTable();
    })
</script>
<div class="col-sm-3">
    <a class="btn btn-default" href="/client/list" style="width:100%">List Upcoming Appointments</a>
    <br>
    <br>
    <a class="btn btn-danger" href="/client/new" style="width:100%">Schedule New Appointment</a>
</div>
<div class="col-sm-9">
    <table class="table table-striped table-hover" id="clientAppointment-table">
        <thead>
        <tr>
            <th>Id</th>
            <th>Type</th>
            <th>Date</th>
            <th>Room Number</th>
            <th>Employee</th>
            <th>Client</th>
        </tr>
        </thead>
        <tbody>

        </tbody>
    </table>
</div>
<%@include file="../includes/footer.jsp" %>
