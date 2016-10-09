<%@ page contentType="text/html" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="mt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="content" />
<html>
<head>
    <meta charset="utf-8">
    <title><fmt:message key="title.comments"/></title>
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
                <c:choose>
                <c:when test="${user.role == \"USER\"}">
                    <li>
                        <form action="controller" method="post">
                            <input type="hidden" name="command" value="user_cabinet_route">
                            <input type="submit" class="btn btn-info" value="<fmt:message key="button.user_cabinet"/>">
                        </form>
                    </li>
                </c:when>
                <c:otherwise>
                        <li>
                            <form action="controller" method="post">
                                <input type="hidden" name="command" value="admin_cabinet_route">
                                <input type="submit" class="btn btn-info" value="<fmt:message key="button.admin_cabinet"/>">
                            </form>
                        </li>
                </c:otherwise>
                </c:choose>
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
    <c:if test="${user.role == \"USER\"}">
        <div class="well">
            <textarea id="commentText" class="form-control" rows="2" placeholder="<fmt:message key="title.comment"/> "></textarea>
            <div class="actions" user-email="${user.email}">
                <button id="send-comment" class="btn btn-default" type="submit"><fmt:message key="button.comment.send"/></button>
            </div>
        </div>
    </c:if>
    <table class="table table-striped ">
        <caption>
            <fmt:message key="title.comments"/>
        </caption>
        <thead>
        <tr>
            <th></th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody class="comments-scroll" id="comments-area">
        <c:forEach items="${comments}" var="current">
            <tr order-id="${current.commentId}" user-email="${current.user.email}">
                <th><c:out value="${current.user.email}"/></th>
                <th><c:out value="${current.time}"/></th>
                <th><c:out value="${current.message}"/></th>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script type="text/javascript" src="../js/ajax-scripts.js"></script>
</body>
</html>
