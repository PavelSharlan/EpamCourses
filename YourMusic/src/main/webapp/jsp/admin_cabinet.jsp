<%@ page contentType="text/html" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="mt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fmr" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="content" />
<html>
<head>
    <meta charset="utf-8">
    <title><fmt:message key="button.admin_cabinet"/></title>
    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/fontello.css">
    <link rel="stylesheet" href="../css/main.css">
    <script src="../js/jquery-3.1.0.js"></script>
    <script src="../js/bootstrap.js" type="text/javascript"></script>
    <script src="../js/ajax-scripts.js"></script>
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
                        <input type="hidden" name="command" value="orders_route">
                        <input type="submit" class="btn btn-info" value="<fmt:message key="title.orders"/>">
                    </form>
                </li>
                <li>
                    <form name="users-form" action="controller">
                        <input type="hidden" name="command" value="show_all_users_route">
                        <input type="submit" class="btn btn-info" value="<fmt:message key="title.users"/>">
                    </form>
                </li>
                <li>
                    <form name="comments-form" action="controller">
                        <input type="hidden" name="command" value="comments_route">
                        <input type="submit" class="btn btn-info" value="<fmt:message key="title.comments"/>">
                    </form>
                </li>
                <li>
                    <a href="#">
                        <button class="btn btn-info" data-toggle="modal" data-target="#myModal3">
                            <fmt:message key="button.add_audio"/>
                        </button>
                        <div class="modal fade" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel3"
                             aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal"
                                                aria-hidden="true">&times;</button>
                                        <h4 class="modal-title" id="myModalLabel"><fmt:message key="label.uploading"/></h4>
                                    </div>
                                    <div class="modal-body">
                                            <div class="form-group-inline">
                                                <form name="load_audio" action="/uploader" method="post" enctype="multipart/form-data">
                                                    <div class="form-group">
                                                        <label for="audio_name"><fmt:message key="label.audio_name"/></label>
                                                        <input id="audio_name" type="text" name="audio_name" class="form-control input" />
                                                    </div>
                                                    <br/>
                                                    <div class="form-group">
                                                        <label for="singer"><fmt:message key="label.singer"/></label>
                                                        <input id="singer" type="text" name="singer" class="form-control input" />
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="genre"><fmt:message key="label.genre"/></label>
                                                        <input id="genre" type="text" name="genre" class="form-control input" />
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="price"><fmt:message key="label.price"/></label>
                                                        <input id="price" type="text" name="price" class="form-control input" pattern="(^[1-9]{1}$)" title="Incorrect price" required  />
                                                    </div>
                                                    <br/>
                                                    <label class="btn btn-default btn-file">
                                                        <fmt:message key="label.audio"/>
                                                        <input type="file" name="audio" size="50" style="display: none;"/>
                                                    </label>
                                                    <br/>
                                                    <label class="btn btn-default btn-file">
                                                        <fmt:message key="label.demo_audio"/>
                                                        <input type="file" name="demo_audio" size="50" style="display: none;"/>
                                                    </label>
                                                    <br/>
                                                    <input type="submit" class="btn btn-primary" value="<fmt:message key="button.upload"/>"/>
                                                </form>
                                            </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default" data-dismiss="modal"><fmt:message key="button.close"/></button>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </a>
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
    <c:if test="${error != null}">
        <div class="alert alert-danger" id="myAlert">
            <a href="#" class="close" data-dismiss="alert" data-target="alert-danger" aria-label="close">&times;</a>
            <strong>${error}</strong>
        </div>
    </c:if>
    <table class="table table-striped ">
        <caption>
            <fmt:message key="label.audios"/>
        </caption>
        <thead>
        <tr>
            <th><fmt:message key="label.singer"/></th>
            <th></th>
            <th></th>
            <th><fmr:message key="label.price"/></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${audios}" var="current">
            <tr>
                <th>
                    <c:out value="${current.singer}"/>
                </th>
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
                    <form name="audio-settings-form" action="controller">
                        <input type="hidden" name="command" value="edit_audio_info_route">
                        <input type="hidden" name="audio_id" value="${current.audioId}">
                        <button type="submit" class="btn btn-success">
                            <span class="glyphicon glyphicon-pencil"></span>
                        </button>
                    </form>
                </th>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</div>
</body>
</html>