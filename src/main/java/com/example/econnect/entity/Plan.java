package com.example.econnect.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Plan {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
