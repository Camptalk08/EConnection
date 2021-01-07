package com.example.econnect.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table
public class Subscriber {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer subcriberId;
	private String name;
	private String gender;
	private String adharcardNumber;
	private Integer age;
	private String email;
	private Long alernate_mobile_number;
	private String password;
}
