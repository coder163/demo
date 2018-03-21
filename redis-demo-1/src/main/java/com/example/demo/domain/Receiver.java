package com.example.demo.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.websocket.WebSocket;

import lombok.extern.slf4j.Slf4j;

/*在任何一个基于消息的应用中，都有消息发布者和消息接收者（或者称为消息订阅者）。创建消息的接收者，我们只需一个普通POJO，在POJO中定义一个接收消息的方法即可：*/
@Slf4j
@Component
public class Receiver {
/*	这个Receiver类将会被注册为一个消息监听者时。处理消息的方法我们可以任意命名，我们有相当大的灵活性。*/

	@Autowired
	private WebSocket webSocket;
  
    
    public void receiveWebsocket(String message) {
        log.info("接收到的消息是 <" + message + ">");
        webSocket.radioMessage(message);
    }
    
}
