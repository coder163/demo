package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.domain.User;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SpringbootDemo1ApplicationTests {
	@Test
	public void contextLoads() {
		List<User> list=new ArrayList<>();
		User u=new User();
		u.setUname("xiaohei");
		list.add(u);
		
		for(User us:list){
			us.setUname("小明");
		}
		log.info(list.get(0).getUname());
	}

	@Test
	public void demo1(){
		log.info("{}","DBCDDD995DB5D728C676E54EDD8F2749".getBytes().length);
	}
}
