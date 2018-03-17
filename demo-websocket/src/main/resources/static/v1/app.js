var websocketClient = null;

function showMessage(data) {
	var div=document.getElementById("showMsg");
	div.innerHTML=div.innerHTML+data+"："+ new Date().toLocaleString()+"<br />"
};
/* 创建一个方法,用来连接我们的websocket服务 */
function connection(url) {
	// 创建websocket对象
	if ('WebSocket' in window) {
		websocketClient = new WebSocket(url);
		console.info(websocketClient);
	} else {
		alert('Not support websocket')
	}
	websocketClient.onopen = function() {
		console.info("连接建立")
	}
	// 接收到消息的回调方法
	websocketClient.onmessage = function(event) {
		console.info("接收到服务器的消息:" + event.data);
		showMessage(event.data);
	}
};

function sendMsg() {
	websocketClient.send($("#msg").val());
}

