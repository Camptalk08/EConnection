package com.example.econnect.service;

import com.example.econnect.dto.ConnectionRequestDTO;
import com.example.econnect.dto.ResponseDTO;

public interface ConnectionService {

	public ResponseDTO connectionRequest(ConnectionRequestDTO connectionRequestDTO,int mobileId,int planId);

}
