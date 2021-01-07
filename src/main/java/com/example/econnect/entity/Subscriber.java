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
		public Integer getSubcriberId() {
		return subcriberId;
	}
	public void setSubcriberId(Integer subcriberId) {
		this.subcriberId = subcriberId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAdharcardNumber() {
		return adharcardNumber;
	}
	public void setAdharcardNumber(String adharcardNumber) {
		this.adharcardNumber = adharcardNumber;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getAlernate_mobile_number() {
		return alernate_mobile_number;
	}
	public void setAlernate_mobile_number(Long alernate_mobile_number) {
		this.alernate_mobile_number = alernate_mobile_number;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
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
