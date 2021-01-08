package com.example.econnect.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.econnect.entity.Subscriber;

@Repository
public interface SubscriberRepository extends JpaRepository<Subscriber, Integer> {

	Optional<Subscriber> findByEmail(String email);

	Optional<Subscriber> findByAlernateMobileNumber(Long alernateMobileNumber);

}
