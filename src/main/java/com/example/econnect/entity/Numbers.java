package com.example.econnect.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Numbers {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer mobileNumberId;
	private Long mobileNumber;
	private String status;

	public Integer getMobileNumberId() {
		return mobileNumberId;
	}

	public void setMobileNumberId(Integer mobileNumberId) {
		this.mobileNumberId = mobileNumberId;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
