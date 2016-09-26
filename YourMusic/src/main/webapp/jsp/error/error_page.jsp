<%@ page contentType="text/html" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="mt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fmr" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="content" />
<html>
<head>
    <title><fmt:message key="title.error"/></title>
    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/fontello.css">
    <link rel="stylesheet" href="../css/main.css">
    <script src="../js/jquery-3.1.0.js"></script>
    <script src="../js/bootstrap.js" type="text/javascript"></script>
</head>
<body>
<h1>Ooops...</h1>
<div class="container">
    <div class="row">
        <div class="col-md-6">
            <h2>Error</h2>
        </div>
    </div>
    <div class="row">
        <div class="col-md-6">
            <img src="../../img/error.jpg">
        </div>
    </div>

</div>
<form action="controller">
    <input type="hidden" name="command" value="login_route">
    <button type="submit" class="btn btn-default">To log in page</button>
</form>
</body>
</html>
