
/* 创建一个方法,用来连接我们的websocket服务 */
function connection(url) {
	if ("WebSocket" in window) {
		console.log("您的浏览器支持 WebSocket!");
		// 打开一个 web socket
		var ws = new WebSocket(url);
		console.info(ws.readyState);
		
		ws.onmessage = function(evt) {
			var received_msg = evt.data;
			console.log("数据已接收..."+received_msg);
			showMessage(received_msg);
		};
	
	}else {
		// 浏览器不支持 WebSocket
		alert("您的浏览器不支持 WebSocket!");
	}
};

function showMessage(data) {
	var div = document.getElementById("showMsg");
	div.innerHTML = div.innerHTML + data+"<br />"
};
