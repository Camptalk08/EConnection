package com.example.econnect.controller;


//test push command
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.econnect.dto.ActionModelDTO;
import com.example.econnect.dto.ConnectionRequestDTO;
import com.example.econnect.dto.NumberResponseDto;
import com.example.econnect.dto.PlansResponseDto;
import com.example.econnect.dto.ResponseDTO;
import com.example.econnect.entity.Admin;
import com.example.econnect.entity.Connection;
import com.example.econnect.service.ConnectionService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ConnectionsController {

	@Autowired
	ConnectionService connectionService;

	/**
	 * 
	 * @author Janani
	 *
	 *         This method will fetch all the mobile numbers available for the subscriber.
	 * @return NumbersResponseDto - list of all the available mobilenumbers & its corresponding status
	 *      
	 **/
	@GetMapping("/numbers")
	public ResponseEntity<List<NumberResponseDto>> getAllTheMobileNumbers() {
		log.info("List of mobile numbers");
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
	public ResponseEntity<Optional<ResponseDTO>> connectionRequest(@RequestBody ConnectionRequestDTO connectionRequestDTO,
			@PathVariable int mobileId, @PathVariable int planId) {

		return new ResponseEntity<>(connectionService.connectionRequest(connectionRequestDTO, mobileId, planId),
				HttpStatus.CREATED);

	}

	@PostMapping("/admin")
	public Integer addAdmin(@RequestBody Admin admin) {
		Integer adminId = connectionService.addAdmin(admin);
		if (adminId != null) {
			return adminId;
		} else {
			return null;
		}
	}

	@PutMapping("/action/{sub_no}")
	public String updateConnectionStatus(@PathVariable("sub_no") String sub_no, @RequestBody ActionModelDTO model) {

		Connection connection = connectionService.getConnectionRequest(sub_no);
		if (model.getStatus() != null
				&& (model.getStatus().equalsIgnoreCase("Approved") || model.getStatus().equalsIgnoreCase("Rejected"))) {
			connection.setStatus(model.getStatus());
			connectionService.updateConnectionStatus(connection);
			return "success";
		} else {
			return "Failed";
		}

	}

	@GetMapping("/connection")
	public List<Connection> getConnections() {
		List<Connection> connections = connectionService.getConnections();

		if (connections != null) {
			return connections;
		} else {
			return null;
		}

	}

}
