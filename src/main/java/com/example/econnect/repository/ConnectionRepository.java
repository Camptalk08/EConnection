package com.example.econnect.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.econnect.entity.Connection;


@Repository
public interface ConnectionRepository extends JpaRepository<Connection, Integer> {
	
	public Optional<Connection> findBySubscriber(int id);

}
