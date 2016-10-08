<%@ page contentType="text/html" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="mt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="content" />
<html>
<head>
    <title>
        <fmt:message key="title.settings" />
        <meta charset="utf-8">
        <title><fmt:message key="title.main_page"/></title>
        <link rel="stylesheet" href="../css/bootstrap.css">
        <link rel="stylesheet" href="../css/bootstrap.min.css">
        <link rel="stylesheet" href="../css/fontello.css">
        <link rel="stylesheet" href="../css/main.css">
        <script src="../js/jquery-3.1.0.js"></script>
        <script src="../js/bootstrap.js" type="text/javascript"></script>
    </title>
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
                    <form name="audio-form" action="controller">
                        <input type="hidden" name="command" value="user_cabinet_route">
                        <input type="submit" class="btn btn-primary" value="<fmt:message key="button.user_cabinet"/>">
                    </form>
                </li>
                <li>
                    <form name="audio-form" action="controller">
                        <input type="hidden" name="command" value="show_all_audios">
                        <input type="submit" class="btn btn-info" value="<fmt:message key="button.audios"/>">
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

<div class="content">
    <div class = "container">
        <div class="col-md-offset-3 col-md-6">
            <c:if test="${error != null}">
                <div class="alert alert-danger" id="myAlert">
                    <a href="#" class="close" data-dismiss="alert" data-target="alert-danger" aria-label="close">&times;</a>
                    <strong>${error}</strong>
                </div>
            </c:if>
        <form name="editUserSettingsForm" action="controller" method="post" id="form-register">
            <h3><span class="label label-default"><fmt:message key="title.settings"/></span></h3>
            <div class="settings-content">
                <input type = "hidden" name = "command" value = "edit_user_settings">
                <div class="form-group-inline">
                    <label for="first_name"><fmt:message key="label.name"/><span class="star">*</span></label>
                    <input type="text" id="first_name" name="first_name" value="${user.firstName}" class="form-control input" pattern="[^\s\d]{2,}" title = "Two or more letters" required>
                </div>
                <div class="form-group-inline">
                    <label for="last_name"><fmt:message key="label.last_name"/><span class="star">*</span></label>
                    <input type="text" id="last_name" name="last_name" value="${user.secondName}" class="form-control input" pattern="[^\s\d]{2,}" title = "Two or more letters" required>
                </div>
                <div class="form-group-inline">
                    <label for="phone"><fmt:message key="label.phone_number"/><span class="star">*</span></label>
                    <input type="text" id="phone" name="phone_number" value="${user.phoneNumber}" class="form-control input" pattern="(\+)?[0-9]{7,13}" required>
                </div>
                <div class="form-group-inline">
                    <label for="email2">e-mail<span class="star">*</span></label>
                    <input type="email" id="email2" name="email" value="${user.email}" class="form-control input"
                           pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" required>
                </div>

                <input type="submit" value="<fmt:message key="button.save"/>" class="btn btn-login-submit"/>
                <br/>
            </div>
        </form>
        <form name="editUserSettingsForm" action="controller" method="post" id="form-edit-password">
            <h3><span class="label label-default"><fmt:message key="title.change_password"/></span></h3>
            <div class="settings-content">
                <input type = "hidden" name = "command" value = "edit_password">
                <div class="form-group-inline">
                    <label for="old_password"><fmt:message key="label.old_password"/><span class="star">*</span></label>
                    <input type="password" id="old_password" name="old_password" class="form-control input" pattern=".{3,}" title="Three or more characters" required>
                </div>
                <div class="form-group-inline">
                    <label for="new_password1"><fmt:message key="label.new_password"/><span class="star">*</span></label>
                    <input type="password" id="new_password1" name="new_password1" class="form-control input" pattern=".{3,}" title="Three or more characters" required>
                </div>
                <div class="form-group-inline">
                    <label for="new_password2"><fmt:message key="label.new_password_confirm"/><span class="star">*</span></label>
                    <input type="text" id="new_password2" name="new_password2" class="form-control input" pattern=".{3,}" title="Three or more characters" required>
                </div>
                ${password_error}
                <input type="submit" value="<fmt:message key="button.change_password"/>" class="btn btn-login-submit"/>

            </div>
        </form>
        </div>
    </div>
    </div>
</body>
</html>
