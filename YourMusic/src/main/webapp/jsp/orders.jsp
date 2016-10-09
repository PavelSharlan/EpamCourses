<%@ page contentType="text/html" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="mt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="content" />
<html>
<head>
    <meta charset="utf-8">
    <title><fmt:message key="title.orders"/></title>
    <script src="../js/jquery-3.1.0.js"></script>
    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/fontello.css">
    <link rel="stylesheet" href="../css/main.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
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
                        <input type="hidden" name="command" value="admin_cabinet_route">
                        <input type="submit" class="btn btn-info" value="<fmt:message key="button.admin_cabinet"/>">
                    </form>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <form name="audio-form" action="controller" method="post">
                        <input type="hidden" name="command" value="logout">
                        <input type="submit" class="btn btn-primary" value="<fmt:message key="button.log_out"/>">
                    </form>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="col-md-offset-3 col-md-7">
    <table class="table table-striped ">
        <caption>
            <fmt:message key="title.orders"/>
        </caption>
        <thead>
        <tr>
            <th></th>
            <th></th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody class="orders-scroll" id="orders-area">
            <c:forEach items="${orders}" var="current">
                <tr order-id="${current.id}">
                    <th><c:out value="${current.userLogin}"/></th>
                    <th><c:out value="${current.singer}"/></th>
                    <th><c:out value="${current.audioName}"/></th>
                    <th>
                        <span class="delete-order">
                            <i class="fa fa-times" aria-hidden="true"></i>
                        </span>
                    </th>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<script type="text/javascript" src="../js/ajax-scripts.js"></script>
</body>
</html>
