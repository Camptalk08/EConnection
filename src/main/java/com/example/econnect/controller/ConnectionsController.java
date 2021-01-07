package com.example.econnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.econnect.service.ConnectionService;

@RestController
public class ConnectionsController {
	
	@Autowired
	ConnectionService connectionService;

}
