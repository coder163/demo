package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.demo.domain.Person;

public interface PersionDao extends JpaRepository<Person, Integer>, JpaSpecificationExecutor<Person> {
	//根据 lastName 来获取对应的 Person
	Person getByLastName(String lastName);
}
