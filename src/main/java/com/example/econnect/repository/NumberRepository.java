package com.example.econnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.econnect.entity.Numbers;



public interface NumberRepository  extends JpaRepository<Numbers, Integer>{
	 
	public Numbers findByMobileNumberId(Integer Id);

}
