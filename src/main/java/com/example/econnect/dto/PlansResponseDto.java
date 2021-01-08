package com.example.econnect.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlansResponseDto {
	
	private Integer talkTimeId;
	private String talkTimePlan;
	private Integer validity;
	private Integer charges;
	public Integer getTalkTimeId() {
		return talkTimeId;
	}
	public void setTalkTimeId(Integer talkTimeId) {
		this.talkTimeId = talkTimeId;
	}
	public String getTalkTimePlan() {
		return talkTimePlan;
	}
	public void setTalkTimePlan(String talkTimePlan) {
		this.talkTimePlan = talkTimePlan;
	}
	public Integer getValidity() {
		return validity;
	}
	public void setValidity(Integer validity) {
		this.validity = validity;
	}
	public Integer getCharges() {
		return charges;
	}
	public void setCharges(Integer charges) {
		this.charges = charges;
	}
	
}
