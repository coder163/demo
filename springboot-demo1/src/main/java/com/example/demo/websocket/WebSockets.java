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

//@ServerEndpoint(value="/push")
@Component
@Slf4j
public class WebSockets {
	private static CopyOnWriteArraySet<WebSockets> webSocketSet = new CopyOnWriteArraySet<>();
    private Session session;


    @OnOpen
    public void onOpen(Session session,EndpointConfig config) {
    	webSocketSet.add(this);
        this.session = session;
        
        log.info("【websocket消息】有新的连接, 总数:{}", webSocketSet.size());
    }
    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("【websocket消息】收到客户端发来的消息:{}", message);
    }
    @OnClose
    public void onClose() {
        log.info("【websocket消息】连接断开, 总数:{}", webSocketSet.size());
    }

    @OnError
    public void onError(Throwable e, Session session){
        log.info("【websocket消息】连接出错或未关闭socket："+e.getMessage());

    }




}
