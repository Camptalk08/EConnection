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

}
