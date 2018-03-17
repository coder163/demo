package com.example.demo.v1.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.Commit;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MyApplicationListener implements ApplicationListener<MyAppApplicationEvent> {

	@Override
	public void onApplicationEvent(MyAppApplicationEvent event) {
		log.info("监听器开始干活");
	}

}
