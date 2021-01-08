package com.example.econnect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.econnect.dto.ConnectionRequestDTO;
import com.example.econnect.dto.NumberResponseDto;
import com.example.econnect.dto.PlansResponseDto;
import com.example.econnect.dto.ResponseDTO;
import com.example.econnect.service.ConnectionService;
import com.sun.tools.sjavac.Log;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ConnectionsController {

	@Autowired
	ConnectionService connectionService;

	@GetMapping("/numbers")
	public ResponseEntity<List<NumberResponseDto>> getAllTheMobileNumbers() {
		Log.info("List of mobile numbers");
		List<NumberResponseDto> response = connectionService.getAllTheNumbers();
		return new ResponseEntity<List<NumberResponseDto>>(response, HttpStatus.OK);
	}

	/**
	 * 
	 * @author Ajith
	 *
	 *         This method will fetch all the plans available for the subscriber.
	 * @return PlansResponseDto - list of all the available plans talktime, charges
	 *         & plans
	 **/
	@GetMapping("/plans")
	public ResponseEntity<List<PlansResponseDto>> getAllThePlans() {
		// log.info("Inside getAllThePlans method");
		List<PlansResponseDto> response = connectionService.getAllThePlans();
		return new ResponseEntity<List<PlansResponseDto>>(response, HttpStatus.OK);
	}

	@GetMapping("/connection/{Id}")
	public ResponseEntity<String> viewConnectionStatus(@PathVariable("Id") int id) {
		String status = connectionService.connectionStatus(id);
		return new ResponseEntity<String>(status, HttpStatus.OK);

	}

	@PostMapping("/subscribers/{mobileId}/{planId}")
	public ResponseEntity<ResponseDTO> connectionRequest(@RequestBody ConnectionRequestDTO connectionRequestDTO,
			@PathVariable int mobileId, @PathVariable int planId) {

		return new ResponseEntity<>(connectionService.connectionRequest(connectionRequestDTO, mobileId, planId),
				HttpStatus.CREATED);

	}

}
