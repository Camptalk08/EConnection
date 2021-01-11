package com.example.econnect.repository;

import com.example.econnect.entity.Connection;
import com.example.econnect.entity.Numbers;
import com.example.econnect.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Connection, Integer> {

    Connection findBySubscriberId(Integer sub_no);
}
