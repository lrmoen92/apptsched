<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>

    <%--FAVICON--%>

    <c:url value="/webjars/jquery/3.2.1/jquery.min.js" var="jquery"/>
    <script src="${jquery}"></script>
    <c:url value="/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js" var="bootstrapJS"/>
    <script src="${bootstrapJS}"></script>

    <c:url value="/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css" var="bootstrapCSS"/>
    <link rel="stylesheet" href="${bootstrapCSS}" media="screen" />

    <c:url value="../../../static/js/apptsched.js" var="common" />
    <script src="${common}"></script>

    <c:url value="../../../static/css/apptsched.css" var="bootstrapCustom" />
    <link rel="stylesheet" href="${bootstrapCustom}" media="screen" />

    <title>Aston Technologies HR Application</title>


</head>
<body>