package com.example.econnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.econnect.entity.Connection;


public interface ConnectionRepository extends JpaRepository<Connection, Integer> {

}
