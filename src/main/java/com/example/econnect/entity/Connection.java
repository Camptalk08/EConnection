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
public class Connection {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int connectionId;
	private int subcriberId;
	private int mobileNumberId;
	private int talkTimeId;
	private String status;
	private String remarks;
	public int getConnectionId() {
		return connectionId;
	}
	public void setConnectionId(int connectionId) {
		this.connectionId = connectionId;
	}
	public int getSubcriberId() {
		return subcriberId;
	}
	public void setSubcriberId(int subcriberId) {
		this.subcriberId = subcriberId;
	}
	public int getMobileNumberId() {
		return mobileNumberId;
	}
	public void setMobileNumberId(int mobileNumberId) {
		this.mobileNumberId = mobileNumberId;
	}
	public int getTalkTimeId() {
		return talkTimeId;
	}
	public void setTalkTimeId(int talkTimeId) {
		this.talkTimeId = talkTimeId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
