package com.example.econnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.econnect.dto.ConnectionRequestDTO;
import com.example.econnect.dto.ResponseDTO;
import com.example.econnect.service.ConnectionService;

@RestController
public class ConnectionsController {

	@Autowired
	ConnectionService connectionService;

	@PostMapping("/subscribers/{mobileId}/{planId}")
	public ResponseEntity<ResponseDTO> connectionRequest(@RequestBody ConnectionRequestDTO connectionRequestDTO, @PathVariable int mobileId,
			@PathVariable int planId) {

		return new ResponseEntity<>(connectionService.connectionRequest(connectionRequestDTO,mobileId,planId),HttpStatus.CREATED);

	}

}
