package com.example.econnect.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.econnect.entity.Connection;
import com.example.econnect.entity.Numbers;
import com.example.econnect.entity.Subscriber;
import com.example.econnect.repository.ConnectionRepository;
import com.example.econnect.repository.ConnectionRequestRepository;
import com.example.econnect.repository.NumberRepository;
import com.example.econnect.service.ConnectionService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ConnectionServiceImpl implements ConnectionService{
	@Autowired
	ConnectionRequestRepository connectionRequestRepository;
	
	@Autowired
	ConnectionRepository connectionRepository;
	
	@Autowired
	NumberRepository numberRepository;

	@Scheduled(fixedRate = 10000)
	public void enableConnection() {
		List<Connection> connection=connectionRepository.findAll();
		Numbers num=null;
	    for (Connection connectionEnable : connection) {
			if(connectionEnable.getStatus().equalsIgnoreCase("APPROVED"))
			{
				connectionEnable.setStatus("CONNCTION ESTABLISHED");
			     num=	numberRepository.findByMobileNumberId(connectionEnable.getNumber());
			    num.setStatus("ALLOTED");
			    numberRepository.save(num);
			    connectionRepository.save(connectionEnable);
			}
			
			
		}
		
	}

}
