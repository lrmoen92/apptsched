<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html>
<head>

    <%--FAVICON--%>

    <c:url value="/webjars/jquery/2.1.4/jquery.min.js" var="jquery"/>
    <script src="${jquery}"></script>

    <c:url value="/webjars/bootstrap/3.3.4/js/bootstrap.min.js" var="bootstrapJS"/>
    <script src="${bootstrapJS}"></script>

    <c:url value="/webjars/bootstrap/3.3.4/css/bootstrap.min.css" var="bootstrapCSS"/>
    <link rel="stylesheet" href="${bootstrapCSS}" media="screen" />

    <c:url value="../../static/js/apptsched.js" var="common" />
    <script src="${common}"></script>

    <c:url value="../../static/css/apptsched.css" var="cssCustom" />
    <link rel="stylesheet" href="${cssCustom}" media="screen" />

    <c:url value="../../static/css/bootstrap.min.css" var="bootstrapSlate" />
    <link rel="stylesheet" href="${bootstrapSlate}" media="screen" />

    <title>Appointment Scheduler</title>


</head>
<body>