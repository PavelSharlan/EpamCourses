<%@ page contentType="text/html" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="mt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="ctg" uri="/WEB-INF/tld/customTag.tld"%>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="content" />
<html>
<head>
    <meta charset="utf-8">
    <title><fmt:message key="title.main_page"/></title>
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
            <a class="navbar-brand" href="#">YourMusic</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li>
                    <div class="dropdown">
                        <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown"><fmt:message key="button.language"/>
                            <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu">
                            <li>
                                <form class="navbar-form" action="controller" method="post">
                                    <input type="hidden" name="command" value="language">
                                    <input type="hidden" name="lang" value="ru_RU">
                                    <input class="language btn btn-default" id="ru" type="submit" name="rus" value="Русский">
                                </form>
                            </li>
                            <li>
                                <form class="navbar-form"   action="controller" method="post">
                                    <input type="hidden" name="command" value="language">
                                    <input type="hidden" name="lang" value="en_EN">
                                    <input class="language btn btn-default" id="eng" type="submit" name="eng" value="English">
                                </form>
                            </li>
                        </ul>
                    </div>
                </li>
                <li>
                    <form name="audio-form" action="controller">
                        <input type="hidden" name="command" value="all_audios_route">
                        <input type="submit" class="btn btn-info" value="<fmt:message key="button.audios"/>">
                    </form>
                </li>
                <li>
                    <form name="audio-form" action="controller">
                        <input type="hidden" name="command" value="about_us_route">
                        <input type="submit" class="btn btn-info" value="<fmt:message key="button.about_us"/>">
                    </form>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
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

<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
        <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>

    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <div class="carousel-caption">
                <h3 ><fmt:message key="label.first_img"/></h3>
            </div>
            <img src="../img/main1.jpg" alt="Chania">
        </div>
        <div class="item">
            <div class="carousel-caption">
                <h3><fmt:message key="label.second_img"/></h3>
            </div>
            <img src="../img/main2.jpg" alt="Chania">
        </div>
        <div class="item">
            <div class="carousel-caption">
                <h3 ><fmt:message key="label.third_img"/></h3>
            </div>
            <img src="../img/main3.jpg" alt="Chania">
        </div>
        <div class="item">
            <div class="carousel-caption">
                <h3><fmt:message key="label.fourth_img"/></h3>
            </div>
            <img src="../img/main4.jpg" alt="Chania">
        </div>
    </div>

    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>
<footer class="footer">
    <div class="container">
        <div class="date">
            <p align="center" class="text-muted">
                <ctg:today format="dd.MM.yyyy"/>
            </p>
        </div>
    </div>
</footer>
</body>
</html>