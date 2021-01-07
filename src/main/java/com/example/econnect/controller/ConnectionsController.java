package com.example.econnect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.econnect.dto.PlansResponseDto;
import com.example.econnect.service.ConnectionService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/connections")
@Slf4j
public class ConnectionsController {
	
	@Autowired
	ConnectionService connectionService;
	
	/**
	 * 
	 * @author Ajith
	 *
	 *         This method will fetch all the plans available for the subscriber.
	 * @return PlansResponseDto - list of all the available plans talktime, charges
	 * 		   & plans
	 */
	@GetMapping("/plans")
	public ResponseEntity<List<PlansResponseDto>> getAllThePlans() {
		log.info("Inside getAllThePlans method");
		List<PlansResponseDto> response = connectionService.getAllThePlans();
		return new ResponseEntity<List<PlansResponseDto>>(response, HttpStatus.OK);
	}

}
