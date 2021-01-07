package com.example.econnect.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.econnect.repository.ConnectionRequestRepository;
import com.example.econnect.service.ConnectionService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ConnectionServiceImpl implements ConnectionService{
	@Autowired
	ConnectionRequestRepository connectionRequestRepository;

}
