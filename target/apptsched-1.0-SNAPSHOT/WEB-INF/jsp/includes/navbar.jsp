<nav class="navbar navbar-static-top navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <%--HOME--%>
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="/" class="navbar-brand">HOME</a>
        </div>
        <div class="collapse navbar-collapse" id="navbar-collapse-1">
            <ul class="nav navbar-nav">
                <%--PAGE LINKS--%>
                <li><a href="/employee/">Employee</a></li>
                <li><a href="/client/">Client</a></li>
                <li><a href="/admin/">Admin</a></li>
                <li><a href="/angular/">Angular</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <%--LOGOUT LINK--%>
                <li><a href="/profile/">Profile</a></li>
                <li><a href="/logout">Log Out</a></li>
            </ul>
        </div>
    </div>
</nav>
