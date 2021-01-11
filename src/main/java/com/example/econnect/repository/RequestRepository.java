package com.example.econnect.repository;

import com.example.econnect.entity.Connection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends JpaRepository<Connection, Integer> {

    //Connection findBySubscriberId(Integer sub_no);
}
