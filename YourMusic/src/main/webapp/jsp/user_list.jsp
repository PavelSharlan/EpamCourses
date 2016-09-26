<%@ page contentType="text/html" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="mt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="content" />
<html>
<head>
    <meta charset="utf-8">
    <title><fmt:message key="title.users_list"/></title>
    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/fontello.css">
    <link rel="stylesheet" href="../css/main.css">
    <script src="../js/"></script>
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
                    <form action="controller">
                        <input type="hidden" name="command" value="admin_cabinet_route">
                        <input type="submit" class="btn btn-info" value="<fmt:message key="button.admin_cabinet"/>">
                    </form>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <form name="audio-form" action="controller">
                        <input type="hidden" name="command" value="logout">
                        <input type="submit" class="btn btn-primary" value="<fmt:message key="button.log_out"/>">
                    </form>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="col-md-offset-3 col-md-6">
    <table class="table table-striped ">
        <caption>
            <fmt:message key="title.users"/>
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
        <c:forEach items="${users_accounts}" var="current">
            <tr>
                <th><c:out value="${current.user.firstName}"/></th>
                <th><c:out value="${current.user.secondName}"/></th>
                <th><c:out value="${current.user.email}"/></th>
                <th>
                    <c:choose>
                        <c:when test="${current.endDate == null}">
                            <form action="controller" method="post">
                                <input type="hidden" name="command" value="ban_account">
                                <input type="hidden" name="account_id" value="${current.userAccountId}">
                                <button type="submit" class="btn btn-default btn-sm">
                                    <span class="glyphicon glyphicon-remove"></span>
                                </button>
                            </form>
                        </c:when>
                        <c:otherwise>
                            <form action="controller" method="post">
                                <input type="hidden" name="command" value="unban_account">
                                <input type="hidden" name="account_id" value="${current.userAccountId}">
                                <button type="submit" class="btn btn-default btn-sm">
                                    <span class="glyphicon glyphicon-ok"></span>
                                </button>
                            </form>
                        </c:otherwise>
                    </c:choose>
                </th>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
