package com.example.demo.v1.config;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.websocket.Endpoint;
import javax.websocket.Extension;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerApplicationConfig;
import javax.websocket.server.ServerEndpoint;
import javax.websocket.server.ServerEndpointConfig;

import org.apache.catalina.session.StandardSessionFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import lombok.extern.slf4j.Slf4j;

/**
 * 主要的配置类
 *  本类必须要继承Configurator,因为@ServerEndpoint注解中的config属性只接收这个类型
 * @author 侯叶飞
 *
 */
@Configuration 
@Slf4j
public class WebsocketConfig extends ServerEndpointConfig.Configurator {

	private static final String HttpSession = null;
	/* 修改握手,就是在握手协议建立之前修改其中携带的内容 */
	@Override
	public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
		/*如果没有监听器,那么这里获取到的HttpSession是null*/
		StandardSessionFacade ssf = (StandardSessionFacade) request.getHttpSession();
		if (ssf != null) {
			HttpSession session = (HttpSession) request.getHttpSession();
			sec.getUserProperties().put("sessionid", session);
			log.info("获取到的SessionID：{}",session.getId());
		}
		sec.getUserProperties().put("name", "小强");
		super.modifyHandshake(sec, request, response);
	}
	@Bean
	public ServerEndpointExporter serverEndpointExporter() {
		return new ServerEndpointExporter();
	}
}
