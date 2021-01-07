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
public class Numbers {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer mobileNumberId;
	private Integer mobileNumber;
	private String status;
	public Integer getMobileNumberId() {
		return mobileNumberId;
	}
	public void setMobileNumberId(Integer mobileNumberId) {
		this.mobileNumberId = mobileNumberId;
	}
	public Integer getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Integer mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
