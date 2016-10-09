<%@ page contentType="text/html" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="mt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="content" />
<html>
<head>
    <meta charset="utf-8">
    <title><fmt:message key="title.authorization"/></title>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/fontello.css">
    <link rel="stylesheet" href="../css/style.css">
</head>

<body>
<div class="col-md-offset-3 col-md-6">
<div class="content">
    <div class = "container">
                    <form name="loginForm" action="controller" method="post" id="form-login">
                        <h3 class="head"><fmt:message key="title.authorization"/></h3>
                        <div class="login-content">
                            <input type = "hidden" name = "command" value = "login">
                            <label for="email1"><fmt:message key="label.email"/></label>
                            <input type="email" id="email1" name="email" required class="form-control" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}">
                            <br/>
                            <label for="password1"><fmt:message key="label.password"/></label>
                            <input type="password" id="password1" name="password" required class="form-control" pattern=".{6,}" title="Three or more characters">
                            <input type="submit" value="<fmt:message key="button.authorization"/>" class="btn btn-login-submit"/>
                            <br/>
                                ${error}
                            <p id="reg-link" class="link"><fmt:message key="button.registration"/></p>
                            <br/>
                        </div>
                    </form>

                <form name="registerForm" action="controller" method="post" id="form-register">
                    <h3 class="head"><fmt:message key="title.registration"/></h3>
                    <div class="login-content">
                    <input type = "hidden" name = "command" value = "register">
                        <div class="form-group-inline">
                            <label for="first_name"><fmt:message key="label.name"/><span class="star">*</span></label>
                            <input type="text" id="first_name" name="first_name" class="form-control input" pattern="^[A-ZА-ЯЁ][a-zа-яё]{2,15}$" title = "2 or more letters" required>
                        </div>
                        <div class="form-group-inline">
                            <label for="last_name"><fmt:message key="label.last_name"/><span class="star">*</span></label>
                            <input type="text" id="last_name" name="last_name" class="form-control input" pattern="^[A-ZА-ЯЁ][a-zа-яё]{2,15}$" title = "2 or more letters" required>
                        </div>
                        <div class="form-group-inline">
                            <label for="phone"><fmt:message key="label.phone_number"/><span class="star">*</span></label>
                            <input type="text" id="phone" name="phone_number" class="form-control input" pattern="(80[17|25|29|33|44][0-9]{8})" required>
                        </div>
                        <div class="form-group-inline">
                            <label for="email2"><fmt:message key="label.email"/><span class="star">*</span></label>
                            <input type="email" id="email2" name="email" class="form-control input"
                                   pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" required>
                        </div>
                        <div class="form-group-inline">
                            <label for="password2"><fmt:message key="label.password"/><span class="star">*</span></label>
                            <input type="password" id="password2" name="password" class="form-control input" pattern=".{6,}" title="Six or more characters"  required>
                        </div>
                        <input type="submit" value="Регистрация" class="btn btn-login-submit"/>
                        <p id="login-link" class="link"><fmt:message key="button.authorization"/></p>
                        <br/>
                    </div>
                </form>
    </div>
</div>
</div>

<script type="text/javascript" src="../js/script-login.js"></script>

</body>
</html>