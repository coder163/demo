package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@SpringBootApplication(scanBasePackages = "com.example.demo")
@EnableTransactionManagement//开启事物
public class SpringdataDemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringdataDemo1Application.class, args);
	}
}
