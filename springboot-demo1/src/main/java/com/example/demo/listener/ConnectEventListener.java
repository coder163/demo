package com.example.demo.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ConnectEventListener implements ApplicationListener<SessionConnectEvent> {
	


	@Override
	public void onApplicationEvent(SessionConnectEvent event) {
		log.info("****************");
	}
}
