package com.example.econnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.econnect.entity.Numbers;


@Repository
public interface NumberRepository  extends JpaRepository<Numbers, Integer>{
	 
	public Numbers findByMobileNumberId(Integer Id);

}
