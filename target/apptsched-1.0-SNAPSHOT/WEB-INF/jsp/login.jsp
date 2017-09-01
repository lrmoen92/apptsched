<%@include file="includes/header.jsp" %>


<div class="container">
    <div class="row">
        <div class="col-sm-6">
            <img src="http://via.placeholder.com/350x150">
        </div>
        <div class="col-sm-6">
            <div>
                <form id="form" action="<c:url value='/login.do'/>" method="POST">
                    <c:if test="${not empty param.err}">
                        <div class="msg-container error text-white">
                            <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>
                        </div>
                    </c:if>
                    <c:if test="${not empty param.out}">
                        <div class="msg-container logout text-white">
                            You've logged out successfully.
                        </div>
                    </c:if>
                    <c:if test="${not empty param.time}">
                        <div class="msg-container time text-white">
                            You've been logged out due to inactivity.
                        </div>
                    </c:if>

                    <br/>
                <div>
                    <label for="usernameInput">Username</label>
                    <input type="text" name="username" id="usernameInput" value="">
                </div>
                <div>
                    <label for="passwordInput">Password</label>
                    <input type="password" name="password" id="passwordInput" value="">
                </div>
                    <br/>
                    <br/>
                <div>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <input value="Login" type="submit" name="submit" class="btn btn-default">
                    <a href="/" class="btn btn-default">Home</a>
                </div>
                </form>
            </div>
        </div>
    </div>
</div>


<%@include file="includes/footer.jsp" %>
