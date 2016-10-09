<%@ page contentType="text/html" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="mt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="content" />
<html>
<head>
    <meta charset="utf-8">
    <title><fmt:message key="button.about_us"/></title>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/fontello.css">
    <link rel="stylesheet" href="../css/main.css">
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#"><fmt:message key="title.your_music"/></a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li>
                    <form action="controller" method="post">
                        <input type="hidden" name="command" value="main_page_route">
                        <input type="submit" class="btn btn-info" value="<fmt:message key="title.main_page"/>">
                    </form>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <form name="register-form" action="controller" method="post">
                        <input type="hidden" name="command" value="login_route">
                        <input type="submit" class="btn btn-primary" value="<fmt:message key="button.login"/>">
                    </form>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="col-md-offset-3 col-md-7">
    <h2><fmt:message key="button.about_us"/></h2>
    <p>

    </p>
</div>
<footer class="footer">
    <div class="container">
        <p align="center" class="text-muted">yourmusic@gmail.com</p>
    </div>
</footer>
</body>
</html>
