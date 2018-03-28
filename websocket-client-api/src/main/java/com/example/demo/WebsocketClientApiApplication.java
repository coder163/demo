package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = "com.example.demo")

public class WebsocketClientApiApplication{

	public static void main(String[] args) {
		SpringApplication.run(WebsocketClientApiApplication.class, args);

	}
}
