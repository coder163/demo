package com.example.demo;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.PersionDao;
import com.example.demo.domain.Person;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SpringdataDemo1ApplicationTests {

	@Autowired
	private PersionDao persionDao;
	
	@Test
	public void insertTest(){
		Person person=new Person();
		person.setLastName("小黑");
		person.setBirth(new Date());
		person.setEmail("admin@coder163.com");
		persionDao.save(person);
	}
	@Test
	public void contextLoads() {
		log.info("{}",persionDao.getByLastName("小黑"));
	}

}
