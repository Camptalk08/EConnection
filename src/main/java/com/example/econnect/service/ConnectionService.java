package com.example.econnect.service;

import java.util.List;
import java.util.Optional;

import com.example.econnect.dto.ConnectionRequestDTO;
import com.example.econnect.dto.NumberResponseDto;
import com.example.econnect.dto.PlansResponseDto;
import com.example.econnect.dto.ResponseDTO;
import com.example.econnect.entity.Admin;
import com.example.econnect.entity.Connection;

public interface ConnectionService {

	public String connectionStatus(int id);

	List<PlansResponseDto> getAllThePlans();

	List<NumberResponseDto> getAllTheNumbers();

	public Optional<ResponseDTO> connectionRequest(ConnectionRequestDTO connectionRequestDTO, int mobileId, int planId);

	Integer addAdmin(Admin admin);

	List<Connection> getConnections();

	Connection getConnectionRequest(String sub_no);

	String updateConnectionStatus(Connection connection);

}
