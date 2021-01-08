package com.example.econnect.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NumberResponseDto {
	
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
