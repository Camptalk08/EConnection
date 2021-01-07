package com.example.econnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.econnect.entity.Plan;

public interface PlansRepository extends JpaRepository<Plan, Integer> {

}
