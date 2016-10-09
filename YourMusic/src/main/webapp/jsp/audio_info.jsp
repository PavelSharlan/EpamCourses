<%@ page contentType="text/html" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="mt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="content" />
<html>
<head>
    <meta charset="utf-8">
    <title><fmt:message key="title.audio_inf"/></title>
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
<div class="content">
    <div class = "container">
        <div class="col-md-offset-3 col-md-6">
            <form name="editAudioInfo" action="controller" method="post">
                <div class="settings-content">
                    <input type = "hidden" name = "command" value = "edit_audio_info">
                    <div class="form-group-inline">
                        <label for="audio_name"><fmt:message key="label.audio_name"/><span class="star">*</span></label>
                        <input type="text" id="audio_name" name="audio_name" value="${audio.name}" class="form-control input">
                    </div>
                    <div class="form-group-inline">
                        <label for="singer"><fmt:message key="label.singer"/><span class="star">*</span></label>
                        <input type="text" id="singer" name="singer" value="${audio.singer}" class="form-control input">
                    </div>
                    <div class="form-group-inline">
                        <label for="price"><fmt:message key="label.price"/><span class="star">*</span></label>
                        <input type="text" id="price" name="price" value="${audio.price}" class="form-control input" pattern="(^\d{0,8}[.,]?\d{1,4}$)" title="Incorrect price" required >
                    </div>
                    <input type="submit" value="<fmt:message key="button.save"/>" class="btn btn-login-submit"/>
                    <br/>
                    <h3>${error}</h3>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
