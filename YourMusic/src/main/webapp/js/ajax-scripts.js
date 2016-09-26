
$(document).ready(function() {
    var alertWarning = function (message) {
        return '<div class="alert alert-warning alert-dismissible fade in result" role="alert">' +
            '  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>' +
            '  <span class="result-text">' + message + '</span></div>';
    };

    var alertError = function (message) {
        return '<div class="alert alert-error alert-dismissible fade in result" role="alert">' +
            '  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>' +
            '  <span class="result-text">' + message + '</span></div>';
    };

    var alertSuccess = function (message) {
        return '<div class="alert alert-success alert-dismissible fade in result" role="alert">' +
            '  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>' +
            '  <span class="result-text">' + message + '</span></div>';
    };

    $("#audios-area").find(".delete-audio").click(function(){
        var data = function(id) {
            return{
                command: "deleteUserAudio",
                id: id
            };
        };
        var id = $(this).parent().parent().attr("audio-id");
        $(this).parent().parent().remove();
        $.ajax({
            type: "POST",
            url: "ajaxController",
            data: JSON.stringify(data(id)),
            dataType: "json",
            async: false,
            headers: {"Access-Control-Allow-Origin": "*"},
            contentType: "application/json; charset=utf-8",
            success: function (responseText) {
                alert("BLA");
            },
            error: function (responseText) {

            }
        });
    });

    $("#orders-area").find(".delete-order").click(function () {
        var data = function (id) {
            return{
                command: "deleteOrder",
                id: id
            };
        };
        var id = $(this).parent().parent().attr("order-id");
        $(this).parent().parent().remove();
        $.ajax({
            type: "POST",
            url: "ajaxController",
            data: JSON.stringify(data(id)),
            dataType: "json",
            async: false,
            headers: {"Access-Control-Allow-Origin": "*"},
            contentType: "application/json; charset=utf-8",
            success: function (responseText) {
            },
            error: function (responseText) {
                ("#orders-area").find(".orders-scroll").before(alertError(JSON.parse(responseText.responseText).text)).show();
            }
        });
    });

    $("#send-comment").click(function(){
       var textArea = $("#commentText");
       var data = function(message){
           return {
             command: "sendComment",
             message: message
           };
       };

        var email = $(this).parent().attr("user-email");

        var tr = function(id, email, time, message) {
            return '<tr order-id="'+id+' user-email="' + email + '"">' +
                '<th>'+email+'</th>' +
                '<th>'+time+'</th>' +
                '<th>'+message+'</th>' +
                '</tr>';
        };

       var message = textArea.val();
       message = message.trim();
       message = message.replace(/(\r\n|\n|\r)/gm," ");
       if(message != ""){
           var task = data(message);
           $.ajax({
               type: "POST",
               url: "ajaxController",
               data: JSON.stringify(task),
               dataType: "json",
               async: false,
               headers: {"Access-Control-Allow-Origin": "*"},
               contentType: "application/json; charset=utf-8",
               success: function(responseText){
                    $(".comments-scroll").prepend(tr(responseText.comment.commentId, email,
                        responseText.comment.time, responseText.comment.message));
                    textArea.val('');
               },
               error: function(responseText){

               }
           });
       }
    });

    $("#all-audios").find(".add-audio-to-basket").click(function (){
        var data = function (id){
            return{
                command: "addAudioToBasket",
                id: id
            };
        };
        var id = $(this).parent().parent().attr("audio-id");

        $.ajax({
            type: "POST",
            url: "ajaxController",
            data: JSON.stringify(data(id)),
            dataType: "json",
            async: false,
            headers: {"Access-Control-Allow-Origin": "*"},
            contentType: "application/json; charset=utf-8",
            success: function (responseText) {
            },
            error: function (responseText) {
                ("#all-audios").find(".all-audio-scroll").before(alertError(JSON.parse(responseText.responseText).text)).show();
            }
        });
    });

    $("#buy-audios").click(function (){
        var data = function(){
            return{
                command: "buyAudios"
            };
        };
        $.ajax({
            type: "POST",
            url: "ajaxController",
            data: JSON.stringify(data()),
            dataType: "json",
            async: false,
            headers: {"Access-Control-Allow-Origin": "*"},
            contentType: "application/json; charset=utf-8",
            success: function (responseText) {
                $(".basket-scroll").children().remove();
            },
            error: function (responseText) {

            }
        });
    });

    $("#purchase-area").on('click','.delete-audio-from-basket', function() {
        debugger;
        var data = function(id) {
            return{
                command: "deletePurchaseFromBasket",
                id: id
            };
        };
        var id = $(this).parent().parent().attr("purchase-id");
        $(this).parent().parent().remove();
        $.ajax({
            type: "POST",
            url: "ajaxController",
            data: JSON.stringify(data(id)),
            dataType: "json",
            async: false,
            headers: {"Access-Control-Allow-Origin": "*"},
            contentType: "application/json; charset=utf-8",
            success: function (responseText) {
            },
            error: function (responseText) {
                ("#purchase-area").find(".basket-scroll").before(alertError(JSON.parse(responseText.responseText).text)).show();
            }
        });
    });

    $("#basket").click(function () {
        debugger;
        var tr = function(id, singer, audioName, price) {
          return '<tr purchase-id="'+id+'">' +
              '<th>'+singer+'</th>' +
              '<th>'+audioName+'</th>' +
              '<th>'+price+'</th>' +
              '<th><span class="delete-audio-from-basket"><i class="fa fa-times" aria-hidden="true"></i></span></th>' +
              '</tr>';
        };

        var data = function () {
            return{
                command: "showBasket"
            };
        };

        $(".basket-scroll").children().remove();

        $.ajax({
            type: "POST",
            url: "ajaxController",
            data: JSON.stringify(data()),
            dataType: "json",
            async: false,
            headers: {"Access-Control-Allow-Origin": "*"},
            contentType: "application/json; charset=utf-8",
            success: function (responseText) {
                for(var i=0; i < responseText.purchases.length; i++) {
                    $(".basket-scroll").append(tr(responseText.purchases[i].id, responseText.purchases[i].audio.singer,
                        responseText.purchases[i].audio.name, responseText.purchases[i].audio.price));
                }
            },
            error: function (responseText) {
                $("#purchase-area").find(".basket-scroll").before(alertError(JSON.parse(responseText.responseText).text)).show();
            }
        });
    });
});