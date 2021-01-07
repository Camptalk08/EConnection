package com.example.econnect.entity;

import java.time.LocalDate;

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
	private Integer mobileNumber;
	private String status;
}
