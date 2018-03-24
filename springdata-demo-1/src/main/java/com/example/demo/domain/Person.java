package com.example.demo.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Table(name = "t_peson")
@Entity
@Data
@ToString
public class Person {
	@GeneratedValue
	@Id
	private Integer id;
	private String lastName;
	private String email;
	private Date birth;
}
