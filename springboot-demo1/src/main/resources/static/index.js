var stompClient = null;
function connect() {
	var socket = new SockJS('/endpoint-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
       
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/stock_info', function (result) {
        	showContent(JSON.parse(result.body));
        });
    });
}



function showContent(body) {
	console.log(body.content);
    $("#notice").html("<tr><td>" + body.content + "</td> <td>"+new Date(body.time).toLocaleString()+"</td></tr>");
}
