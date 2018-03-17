package com.example.demo.v1.listener;

import org.springframework.context.ApplicationEvent;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyAppApplicationEvent extends ApplicationEvent{

	public MyAppApplicationEvent(Object source) {
		super(source);
		log.info("这就是自定义事件?");
	}

}
