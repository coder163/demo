package com.example.demo.websocket;

import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * WebSocket主要的消息类
 * @author 侯叶飞
 */
@ServerEndpoint(value = "/api/websocket")
@Component
@Slf4j
public class WebSocket {
	/*每个浏览器连接都会有一个新的会话对象*/
	private Session session;
	/*用来存储每个会话的session,静态的不会被实例化*/
	private static CopyOnWriteArraySet<WebSocket> webSocketSets = new CopyOnWriteArraySet<>();
	
	@OnOpen
	public void onOpen(Session session) {
		this.session = session;
		webSocketSets.add(this);
		log.info("【websocket消息】有新的连接, 总数:{}", webSocketSets.size());
	}

	@OnClose
	public void onClose() {
		webSocketSets.remove(this);
		log.info("【websocket消息】连接断开, 总数:{}", webSocketSets.size());
	}

	@OnError
	public void onError(Throwable e, Session session) {
		webSocketSets.remove(this);
		log.info("【websocket消息】连接出错或未关闭socket：" + e.getMessage());

	}

	@OnMessage
	public void onMessage(String message, Session session) {
		log.info("【websocket消息】收到客户端发来的消息:{}", message);

	
	}
	public void radioMessage(String message){
		for(WebSocket ws:webSocketSets){
			ws.session.getAsyncRemote().sendText("广播："+message);
		}
	}
}

