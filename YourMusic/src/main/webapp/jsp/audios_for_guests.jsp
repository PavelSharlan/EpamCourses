<%@ page contentType="text/html" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="mt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="content" />
<html>
<head>
    <meta charset="utf-8">
    <title>
        <fmt:message key="label.audios"/>
    </title>
    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/fontello.css">
    <link rel="stylesheet" href="../css/main.css">
    <script src="../js/jquery-3.1.0.js"></script>
    <script src="../js/bootstrap.js" type="text/javascript"></script>
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
                <li>
                    <form action="controller" method="post">
                        <input type="hidden" name="command" value="about_us_route">
                        <input type="submit" class="btn btn-info" value="<fmt:message key="button.about_us"/>">
                    </form>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="#">
                        <span class="glyphicon glyphicon-eye-open"></span>
                    </a>
                </li>
                <li>
                    <form name="register-form" action="controller">
                        <input type="hidden" name="command" value="login_route">
                        <input type="submit" class="btn btn-primary" value="<fmt:message key="button.login"/>">
                    </form>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="col-md-offset-3 col-md-7">
    <table class="table table-striped ">
        <caption>
            <fmt:message key="label.audios"/>
        </caption>
        <thead>
        <tr>
            <th></th>
            <th></th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${demo_audios}" var="current">
            <tr>
                <th><c:out value="${current.singer}"/></th>
                <th><c:out value="${current.name}"/></th>
                <th>
                    <audio controls>
                        <source src="${pageContext.request.contextPath}${current.url}" type="audio/mpeg">
                    </audio>
                </th>
                <th>
                    <c:out value="${current.price}"/>
                </th>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
