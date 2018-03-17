package com.example.demo.config.v3;

import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
//EnableWebSocketMessageBroker已在Spring 4中引入。EnableWebSocketMessageBroker注释使配置类能够支持WebSocket。此注释支持消息代理
@EnableWebSocketMessageBroker() 
public class WebSocketConfigV3 {

}
