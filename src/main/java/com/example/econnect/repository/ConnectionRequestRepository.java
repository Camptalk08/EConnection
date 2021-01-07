package com.example.econnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.econnect.entity.Subscriber;

public interface ConnectionRequestRepository extends JpaRepository<Subscriber, Integer> {

	
}
