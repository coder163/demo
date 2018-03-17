package com.example.demo.websocket.v1;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.thymeleaf.util.MapUtils;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MyHandler extends TextWebSocketHandler {
	 /**
     * 建立连接
     * @param session
     * @throws Exception
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    	Map<String, Object> map = session.getAttributes();
    	
    	log.info("{}",map);
    	Set<String> keySet = map.keySet();
    	Iterator<String> iterator = keySet.iterator();
    	while(iterator.hasNext()){
    		Object key=iterator.next();
    		log.info("拦截器中获取的信息:{}",map.get(key));
    	}
    
    }

    /**
     * 收到客户端消息
     * @param session
     * @param message
     * @throws Exception
     */
    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
    	log.info("收到客户端消息");
    }

    /**
     * 出现异常
     * @param session
     * @param exception
     * @throws Exception
     */
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
    	log.info("出现异常");
    }

    /**
     * 连接关闭
     * @param session
     * @param closeStatus
     * @throws Exception
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
    	log.info("连接关闭");
    }

    /**
     * 是否分段发送消息
     * @return
     */
    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
