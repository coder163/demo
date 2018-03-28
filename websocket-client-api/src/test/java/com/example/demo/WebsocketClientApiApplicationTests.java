package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;
import com.example.demo.client.WebSocketClient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class WebsocketClientApiApplicationTests {
	@Autowired
	private WebSocketClient clientEndPoint;

	@Test
	public void show01() throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("datatype", "API_NEW");
		map.put("data", "27");
		String json = JSON.toJSONString(map);
		log.info("待发送的数据:{}",json);

		while (true) {
			clientEndPoint.sendMessage(json);
			Thread.sleep(30000);
		}
	}

}
