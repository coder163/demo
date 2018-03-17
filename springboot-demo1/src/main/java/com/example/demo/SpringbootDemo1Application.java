package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScans;import com.example.demo.listener.ConnectEventListener;
import com.example.demo.v1.listener.MyAppApplicationEvent;
import com.example.demo.v1.listener.MyApplicationListener;

@SpringBootApplication
public class SpringbootDemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemo1Application.class, args);
		
/*		SpringApplication application=new SpringApplication(SpringbootDemo1Application.class);
		
		application.addListeners(new MyApplicationListener());
		ConfigurableApplicationContext context = application.run(args);
		
		context.publishEvent(new MyAppApplicationEvent(new Object()));
		context.close();
*/	}
}
