package com.example.demo.client;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import javax.websocket.ClientEndpoint;
import javax.websocket.CloseReason;
import javax.websocket.ContainerProvider;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import com.example.demo.consts.SocketEnum;
import com.example.demo.util.GZIPUtils;

/**
 * websocket Java客户端请求示例
 * @author 侯叶飞
 */
@Component
@ClientEndpoint(subprotocols = { "websocket" })
public class WebSocketClient {

	final Logger log = getLogger(lookup().lookupClass());

	Session session;

	public WebSocketClient() {
		try {
			WebSocketContainer container = ContainerProvider.getWebSocketContainer();
			session = container.connectToServer(this, new URI(SocketEnum.WEBSOCKET_SERVER_PATH.getValue()));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@OnOpen
	public void onOpen(Session userSession) {
		log.info("【websocket消息】opening websocket" );
	}

	@OnClose
	public void onClose(Session userSession, CloseReason reason) throws IOException {
		log.info("【websocket消息】closeing websocket" );
		session.close();
	}


	//服务器端发送的是二进制消息,所以需要使用字节流接收
	@OnMessage()
	public void onMessage(InputStream input) throws Exception {
		//解码
		log.info("【websocket消息】接收数据:{}", new String(GZIPUtils.decompress(GZIPUtils.InputStreamTOByte(input))));

	}

	public void sendMessage(String message) throws IOException {
		this.session.getBasicRemote().sendText(message);
	}



}