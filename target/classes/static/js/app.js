var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#notice").html("");
}

function connect() {
	var from = $("#from").val();
	var to=$("#to").val();
	var socket = new SockJS('/endpoint-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/chat/single/'+from, function (result) {
        	showContent(JSON.parse(result.body));
        });
        stompClient.subscribe('/chat/single/'+to, function (result) {
            showMyContent(JSON.parse(result.body));
        });
    });
}

/*function disconnect() {

}*/

function sendName() {/*送给对方的消息,传递到controller的/app/v3/single/chat*/
	
    stompClient.send("/app/single/chat", {}, JSON.stringify({'content': $("#content").val(), 'to':$("#to").val(), 'from':$("#from").val()}));
    
    
}

function showMyContent(body) {/*接收到自己发的消息*/
    $("#notice").append("<tr><td>" + body.content + "</td> <td>"+new Date(body.time).toLocaleString()+"</td></tr>");
}

function showContent(body) {/*自己接收到的消息*/
    $("#notice").append("<tr><td>" + body.content + "</td> <td>"+new Date(body.time).toLocaleString()+"</td></tr>");
}

$(function () {
/*
    $( "#connect" ).click(function() { connect(); });*/
    connect();
   /* $( "#disconnect" ).click(function() { disconnect(); });*/
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#send" ).click(function() { sendName(); });
});

window.addEventListener('unload', function() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
});