package com.example.econnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.econnect.entity.Plan;

@Repository
public interface PlansRepository extends JpaRepository<Plan, Integer> {

}
