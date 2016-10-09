<%@ page contentType="text/html" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="mt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="content" />
<html>
    <head>
        <meta charset="utf-8">
        <title><fmt:message key="button.user_cabinet"/></title>
        <link rel="stylesheet" href="../css/bootstrap.css">
        <link rel="stylesheet" href="../css/bootstrap.min.css">
        <link rel="stylesheet" href="../css/fontello.css">
        <link rel="stylesheet" href="../css/main.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
        <script src="../js/jquery-3.1.0.js"></script>
        <script src="../js/ajax-scripts.js"></script>
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
                    <form name="audio-form" action="controller" method="post">
                        <input type="hidden" name="command" value="show_all_audios">
                        <input type="submit" class="btn btn-info" value="<fmt:message key="button.audios"/>">
                    </form>
                </li>
                <li>
                    <form name="comments-form" action="controller" method="post">
                        <input type="hidden" name="command" value="comments_route">
                        <input type="submit" class="btn btn-info" value="<fmt:message key="title.comments"/>">
                    </form>
                </li>
                <li>
                    <form name="audio-form" action="controller" method="post">
                        <input type="hidden" name="command" value="edit_user_settings_route">
                        <input type="submit" class="btn btn-info" value="<fmt:message key="button.user_settings"/>">
                    </form>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="#">
                        <ul type="none">
                            <li>${user.firstName}: ${user_account.balance} <fmt:message key="label.rub"/></li>
                            <li>
                                <fmt:message key="label.put_money"/>
                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-sm">
                                    <i class="fa fa-plus-circle" aria-hidden="true"></i>
                                </button>
                                <div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
                                    <div class="modal-dialog modal-sm" role="document">
                                        <div class="modal-content">
                                            <form name="put_money_form" action="controller" method="post">
                                                <input type="hidden" name="command" value="put_money">
                                                <div class="form-group-inline">
                                                    <label for="money"><fmt:message key="label.put_money"/></label>
                                                    <input type="text" id="money" name="money" value="${audio.price}" class="form-control input" pattern="(^[1-9][0-9]{0,2}$)" title="Incorrect money" required >
                                                    <input type="submit" value="<fmt:message key="button.put"/>" class="btn btn-login-submit"/>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </a>
                </li>
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
            <fmt:message key="label.my.audios"/>
        </caption>
        <thead>
        <tr>
            <th></th>
            <th></th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody class="audios-scroll" id="audios-area">
        <c:forEach items="${user_audios}" var="current">
        <tr audio-id="${current.audioId}">
            <th><c:out value="${current.singer}"/></th>
            <th><c:out value="${current.name}"/></th>
            <th>
                <audio controls>
                    <source src="${pageContext.request.contextPath}${current.url}" type="audio/mpeg">
                </audio>
            </th>
            <th>
                <span class="delete-audio">
                    <i class="fa fa-times" aria-hidden="true"></i>
                </span>
            </th>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
