package com.example.econnect.service.impl;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.econnect.dto.ConnectionRequestDTO;
import com.example.econnect.dto.ResponseDTO;
import com.example.econnect.repository.ConnectionRepository;
import com.example.econnect.repository.SubscriberRepository;

@RunWith(MockitoJUnitRunner.class)
class ConnectionServiceImplTest {

	@Mock
	SubscriberRepository subscriberRepository;

	@Mock
	ConnectionRepository connectionRepository;

	@InjectMocks
	ConnectionServiceImpl ConnectionServiceImpl;

	ConnectionRequestDTO connectionRequestDTO;
	ResponseDTO responseDTO;

	@Before
	public void setup() {
		connectionRequestDTO = new ConnectionRequestDTO();
		responseDTO = new ResponseDTO();
		responseDTO.setSubscriberId(1);

	}

	@Test
	public void testConnectionRequest() {

		Mockito.when(subscriberRepository.save(Mockito.any())).thenReturn(responseDTO);
		//Mockito.when(connectionRepository.save(Mockito.any())).thenReturn(connection);
	}

}
