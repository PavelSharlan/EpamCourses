<%@ page contentType="text/html" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="mt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="content" />
<html>
<head>
    <meta charset="utf-8">
    <title><fmt:message key="label.audios"/></title>
    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/fontello.css">
    <link rel="stylesheet" href="../css/main.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
    <script src="../js/ajax-scripts.js"></script>
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
                    <form name="audio-form" action="controller" method="post">
                        <input type="hidden" name="command" value="user_cabinet_route">
                        <input type="submit" class="btn btn-primary" value="<fmt:message key="button.user_cabinet"/>">
                    </form>
                </li>
                <li>
                    <div>
                        <button class="btn btn-info" data-toggle="modal" id="basket" data-target="#myModal">
                            <fmt:message key="button.basket"/>
                        </button>
                        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                             aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal"
                                                aria-hidden="true">&times;</button>
                                        <h4 class="modal-title" id="myModalLabel1"><fmt:message key="button.basket"/></h4>
                                    </div>
                                    <div id="audio-basket" class="modal-body">
                                        <table class="table table-striped">
                                            <thead>
                                            <tr>
                                                <th></th>
                                                <th></th>
                                                <th></th>
                                                <th></th>
                                            </tr>
                                            </thead>
                                            <tbody class="basket-scroll" id="purchase-area">
                                                <c:forEach items="${purchases}" var="current">
                                                    <tr purchase-id="${current.id}">
                                                        <th>${current.audio.singer}</th>
                                                        <th>${current.audio.audioName}</th>
                                                        <th>${current.audio.price}</th>
                                                        <th>
                                                            <span class="delete-audio-from-basket">
                                                                <i class="fa fa-times" aria-hidden="true"></i>
                                                            </span>
                                                        </th>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default" data-dismiss="modal"><fmt:message key="button.close"/></button>
                                        <button type="button" class="btn btn-primary" id="buy-audios"><fmt:message key="button.buy"/></button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </li>
                <li>
                    <a href="#">
                        <button class="btn btn-info" data-toggle="modal" data-target="#myModal2">
                            <fmt:message key="button.make_order"/>
                        </button>
                        <div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel2"
                             aria-hidden="true">
                            <div class="modal-dialog">
                                <div id="modal-basket" class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal"
                                                aria-hidden="true">&times;</button>
                                        <h4 class="modal-title" id="myModalLabel"><fmt:message key="button.order"/></h4>
                                    </div>
                                    <form action="controller" method="post">
                                        <input type="hidden" name="command" value="order_audio">
                                        <div class="modal-body">
                                            <div class="form-group-inline">
                                                <label for="singer"><fmt:message key="label.singer"/></label>
                                                <input type="text" id="singer" name="singer" class="form-control input" required>
                                            </div>
                                            <div class="form-group-inline">
                                                <label for="audio_name"><fmt:message key="label.audio_name"/></label>
                                                <input type="text" id="audio_name" name="audio_name" class="form-control input" required>
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal"><fmt:message key="button.close"/></button>
                                            <input type="submit" class="btn btn-primary" value="<fmt:message key="button.make_order"/>">
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </a>
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

<div id="all-music" class="col-md-offset-3 col-md-7">
    <form action="controller" method="post">
        <input type="hidden" name="command" value="sort_music">
        <span>
            <input type="image" name="kind" value="Rock" src="../img/rock.png">
        </span>
        <span>
            <input type="image" name="kind" value="Pop" src="../img/pop.png">
        </span>
        <span>
            <input type="image" name="kind" value="Hip_Hop" src="../img/hip_hop.jpeg">
        </span>
        <span>
            <input type="image" name="kind" value="all_music" src="../img/all_music.png">
        </span>
    </form>
    <table class="table table-striped ">
        <caption>
        </caption>
        <thead>
        <tr>
            <th></th>
            <th></th>
            <th></th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody class="all-audio-scroll" id="all-audios">
        <c:forEach items="${audios}" var="current">
            <tr audio-id="${current.audioId}">
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
                <th>
                    <span class="add-audio-to-basket">
                        <i class="glyphicon glyphicon-plus" aria-hidden="true"></i>
                    </span>
                </th>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="../js/ajax-scripts.js"></script>
<script src="../js/jquery-3.1.0.js"></script>
<script src="../js/bootstrap.js" type="text/javascript"></script>
</body>
</html>