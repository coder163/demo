package com.example.demo.consts;

import lombok.Getter;
/**
 * 常量列表
 * @author 侯叶飞
 *
 */
public enum SocketEnum {

	/**
	 * 连接websocket的服务器地址
	 */
	WEBSOCKET_SERVER_PATH("ws://localhost:8081/api/publics/websocket");
    @Getter
    private String value;
    
    SocketEnum(String value) {
        this.value = value;
    }
}
