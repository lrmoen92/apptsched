<%@include file="../includes/header.jsp" %>
<%@include file="../includes/navbar.jsp" %>
<script src="/static/js/newClientAppointment.js"></script>
<script>
    $(document).ready(function(){
        readyPage();
    })
</script>

<div class="col-sm-3">
    <a class="btn btn-default" href="/client/list" style="width:100%">List Upcoming Appointments</a>
    <br>
    <br>
    <a class="btn btn-default" href="/client/listPrevious" style="width:100%">List Past Appointments</a>
</div>
<div class="col-sm-9">
    <form class="form-horizontal">
        <fieldset>

            <hidden id="appointmentId"/>
            <hidden id="appointmentVersion"/>

            <div class="form-group">
                <label for="inputType" class="col-lg-2 control-label">Type</label>
                <div class="col-lg-10">
                    <input class="form-control" id="inputType" placeholder="Type">
                </div>
            </div>

            <div class="form-group">
                <label for="inputDate" class="col-lg-2 control-label">Date</label>
                <div class="col-lg-10">
                    <input class="form-control" type="datetime-local" id="inputDate" placeholder="Date">
                </div>
            </div>

            <div class="form-group">
                <label for="inputRoom" class="col-lg-2 control-label">Room</label>
                <div class="col-lg-10">
                    <input class="form-control" id="inputRoom" placeholder="Room">
                </div>
            </div>

            <div class="form-group">
                <label for="inputEmployee" class="col-lg-2 control-label">Employee</label>
                <div class="col-lg-10">
                    <select class="form-control" id="inputEmployee">
                        <option>(Select an Employee)</option>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <div class="col-lg-offset-2 col-lg-10">
                    <button type="button" class="btn btn-primary" onclick="saveAppointment()">Save changes</button>
                </div>
            </div>
        </fieldset>
    </form>
</div>
<%@include file="../includes/footer.jsp" %>