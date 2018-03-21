package com.example.demo;

import java.util.concurrent.CountDownLatch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class RedisDemoApplicationTests {

	
	@Autowired
	private StringRedisTemplate template;
	
	@Autowired
	private CountDownLatch latch;

	@Test
	public void test() throws Exception {
		template.convertAndSend("9527", "Hello from Redis!");

		latch.await();
		
    }

}
