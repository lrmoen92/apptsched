<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>
<script src="/static/js/profile.js"></script>
<script>
    buildPage();
</script>


<div class="container">
    <form class="form-horizontal">
        <input type="hidden" id="id">
        <input type="hidden" id="version">
        <div class="col-sm-10 form-group">
            <label class="col-sm-3 control-label">Username</label>
            <div class="col-sm-9 form-group" id="usernameDiv">

            </div>
        </div>
        <div class="col-sm-10 form-group">
            <label class="col-sm-3 control-label">Password</label>
            <div class="col-sm-9 form-group" id="passwordDiv">

            </div>
        </div>
        <div class="col-sm-10 form-group">
            <label class="col-sm-3 control-label">Confirm Password</label>
            <div class="col-sm-9 form-group" id="confirmPasswordDiv">

            </div>
        </div>
        <div class="col-sm-10 form-group">
            <label class="col-sm-3 control-label">First Name</label>
            <div class="col-sm-9 form-group" id="firstDiv">

            </div>
        </div>
        <div class="col-sm-10 form-group">
            <label class="col-sm-3 control-label">Middle Name</label>
            <div class="col-sm-9 form-group" id="middleDiv">

            </div>
        </div>
        <div class="col-sm-10 form-group">
            <label class="col-sm-3 control-label">Last Name</label>
            <div class="col-sm-9 form-group" id="lastDiv">

            </div>
        </div>
        <div class="col-sm-10 form-group">
            <label class="col-sm-3 control-label">Phone Number</label>
            <div class="col-sm-9 form-group" id="phoneNumberDiv">

            </div>
        </div>
        <div class="col-sm-10 form-group">
            <button type="button" class="btn btn-primary col-sm-offset-3" onclick="savePerson()">Submit Changes</button>
        </div>
    </form>
</div>

<%@include file="includes/footer.jsp" %>
