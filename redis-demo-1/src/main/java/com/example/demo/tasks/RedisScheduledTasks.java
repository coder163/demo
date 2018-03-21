package com.example.demo.tasks;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.demo.config.MsgChannel;

@Component
public class RedisScheduledTasks {
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	@Autowired
	private StringRedisTemplate template;
	
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        template.convertAndSend(MsgChannel.CHANNEL_9527, "Hello from Redis!"+dateFormat.format(new Date()));
    }
    
}
