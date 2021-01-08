package com.example.econnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.econnect.entity.Subscriber;

@Repository
public interface ConnectionRequestRepository extends JpaRepository<Subscriber, Integer> {

	
}
