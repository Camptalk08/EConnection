package com.example.econnect.service;

import java.util.List;

import com.example.econnect.dto.ConnectionRequestDTO;
import com.example.econnect.dto.NumberResponseDto;
import com.example.econnect.dto.PlansResponseDto;
import com.example.econnect.dto.ResponseDTO;

public interface ConnectionService {
	
	public String connectionStatus(int id);

	List<PlansResponseDto> getAllThePlans();
	List<NumberResponseDto> getAllTheNumbers();

	public ResponseDTO connectionRequest(ConnectionRequestDTO connectionRequestDTO,int mobileId,int planId);

}
