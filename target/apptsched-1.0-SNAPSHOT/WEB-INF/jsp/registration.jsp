<%@include file="includes/header.jsp" %>
<script src="/static/js/registration.js"></script>
<script>

</script>
<h1>Registration</h1>
<form class="form-horizontal">
    <div class="form-group">
        <label class="col-sm-2 control-label" for="first">First Name</label>
        <div class="col-sm-6">
            <input class="form-control" type="text" placeholder="(First Name)" id="first" />
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label" for="last">Last Name</label>
        <div class="col-sm-6">
            <input class="form-control" type="text" placeholder="(Last Name)" id="last" />
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label" for="username">Username</label>
        <div class="col-sm-6">
            <input class="form-control" type="text" placeholder="(Valid Email Address)" id="username" />
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label" for="password">Password</label>
        <div class="col-sm-6">
            <input class="form-control" type="password" placeholder="(Password)" id="password" />
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label" for="confirmPassword">Confirm Password</label>
        <div class="col-sm-6">
            <input class="form-control" type="password" placeholder="(Confirm Password)" id="confirmPassword" />
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-6">
            <button class="btn btn-primary" type="button" onclick="register()">Submit</button>
            <a href="/" class="btn btn-primary" type="button">Home</a>
        </div>
    </div>
</form>

<%@include file="includes/footer.jsp" %>