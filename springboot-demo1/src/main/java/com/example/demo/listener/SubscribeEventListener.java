package com.example.demo.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SubscribeEventListener implements ApplicationListener<SessionSubscribeEvent>{

	/**
	 * 在事件触发的时候调用这个方法
	 * 
	 * StompHeaderAccessor  简单消息传递协议中处理消息头的基类，
	 * 通过这个类，可以获取消息类型(例如:发布订阅，建立连接断开连接)，会话id等
	 * 
	 */
	public void onApplicationEvent(SessionSubscribeEvent event) {
		StompHeaderAccessor headerAccessor =  StompHeaderAccessor.wrap(event.getMessage());
		log.info("【SubscribeEventListener监听器事件 类型】"+headerAccessor.getCommand().getMessageType());
		
		
	}

}