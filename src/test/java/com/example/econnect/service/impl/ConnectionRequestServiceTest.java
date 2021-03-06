package com.example.econnect.service.impl;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.econnect.dto.ConnectionRequestDTO;
import com.example.econnect.dto.ResponseDTO;
import com.example.econnect.entity.Connection;
import com.example.econnect.entity.Subscriber;
import com.example.econnect.exception.ConnectionRequestException;
import com.example.econnect.repository.ConnectionRepository;
import com.example.econnect.repository.SubscriberRepository;

@RunWith(MockitoJUnitRunner.class)
public class ConnectionRequestServiceTest {

	@Mock
	SubscriberRepository subscriberRepository;

	@Mock
	ConnectionRepository connectionRepository;

	@InjectMocks
	ConnectionServiceImpl connectionServiceImpl;

	Subscriber subscriber;
	Connection connection;
	ConnectionRequestDTO connectionRequestDTO;

	ResponseDTO responseDTO;

	@Before
	public void setup() {

		subscriber = new Subscriber();
		subscriber.setAdharcardNumber("1234");
		subscriber.setAge(26);
		subscriber.setAlernateMobileNumber(90L);
		subscriber.setEmail("shiva@email.com");
		subscriber.setGender("Male");
		subscriber.setName("shiva");
		subscriber.setPassword("shiva@123");
		subscriber.setSubcriberId(1);

		connection = new Connection();
		connection.setMobileNumberId(1);
		connection.setTalkTimeId(1);
		connection.setRemarks("");
		connection.setStatus("Inprogress");

		connectionRequestDTO = new ConnectionRequestDTO();
		connectionRequestDTO.setAdharcardNumber("1234");
		connectionRequestDTO.setAge(26);
		connectionRequestDTO.setAlternateMobileNumber(9030853295L);
		connectionRequestDTO.setEmail("shiva@email.com");
		connectionRequestDTO.setGender("Male");
		connectionRequestDTO.setName("shiva");
		connectionRequestDTO.setPassword("shiva@123");

	}

	@Test
	public void connectionRequestTest() {

		Mockito.when(subscriberRepository.save(Mockito.any())).thenReturn(subscriber);
		Mockito.when(connectionRepository.save(Mockito.any())).thenReturn(connection);
		Optional<ResponseDTO> responseDTO = connectionServiceImpl.connectionRequest(connectionRequestDTO, 1, 1);
		Assert.assertNotNull(responseDTO);

	}

	@Test(expected = ConnectionRequestException.class)
	public void invalidEmailTest() {
		connectionRequestDTO.setEmail("shiva.com");
		connectionServiceImpl.connectionRequest(connectionRequestDTO, 1, 1);

	}

	@Test(expected = ConnectionRequestException.class)
	public void invalidPhoneTest() {
		connectionRequestDTO.setAlternateMobileNumber(90L);
		connectionServiceImpl.connectionRequest(connectionRequestDTO, 1, 1);
	}

	@Test(expected = ConnectionRequestException.class)
	public void userAlreadyExistsTest() {
		Mockito.when(subscriberRepository.findByEmail(connectionRequestDTO.getEmail()))
				.thenReturn(Optional.of(subscriber));
		connectionServiceImpl.connectionRequest(connectionRequestDTO, 1, 1);

	}

	@Test(expected = ConnectionRequestException.class)
	public void connectionNotAvailableTest() {
		Mockito.when(connectionRepository.findByMobileNumberId(1)).thenReturn(Optional.of(connection));
		connectionServiceImpl.connectionRequest(connectionRequestDTO, 1, 1);

	}

}