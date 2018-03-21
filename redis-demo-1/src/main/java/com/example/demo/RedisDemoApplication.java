package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RedisDemoApplication {
	
	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(RedisDemoApplication.class, args);
	}
}
