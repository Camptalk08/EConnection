package com.example.econnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.econnect.service.ConnectionService;

@RestController
public class ConnectionsController {
	
	@Autowired
	ConnectionService connectionService;
	
	@GetMapping("/connection/{Id}")
	public ResponseEntity<String> viewConnectionStatus(@PathVariable("Id") int id )
	{
		String status=connectionService.connectionStatus(id);
		return new ResponseEntity<String>(status,HttpStatus.OK);
		
	}

}
