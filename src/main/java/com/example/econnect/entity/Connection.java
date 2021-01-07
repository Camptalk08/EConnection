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
public class Connection {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer connectionId;
	private Integer subscriber;
	private Integer number;
	private Integer plan;
	private LocalDate date;
	private String status;

}
