package com.example.econnect.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.example.econnect.dto.PlansResponseDto;
import com.example.econnect.service.ConnectionService;

@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
public class ConnectionsControllerTest {


	@Mock
	ConnectionService connectionService;

	@InjectMocks
	ConnectionsController connectionsController;
	
	List<PlansResponseDto> plansResponseDtos;

	PlansResponseDto plansResponseDto;

	@BeforeAll
	public void setup() {
		plansResponseDto = new PlansResponseDto();
		plansResponseDto.setTalkTimeId(1);
		plansResponseDto.setCharges(223);
		plansResponseDto.setTalkTimePlan("unlimited talk time");
		plansResponseDto.setValidity(28);
		plansResponseDtos = new ArrayList<PlansResponseDto>();
		plansResponseDtos.add(plansResponseDto);
		
	}

	@Test
	@DisplayName("Getting all the available plans")
	public void viewRequestedListTest() {

		// WHEN
		when(connectionService.getAllThePlans())
				.thenReturn(plansResponseDtos);
		ResponseEntity<List<PlansResponseDto>> actual = connectionsController
				.getAllThePlans();
		// THEN
		Assertions.assertEquals(actual.getBody().get(0).getTalkTimeId(),plansResponseDtos.get(0).getTalkTimeId());
		Assertions.assertEquals(actual.getBody().get(0).getCharges(),plansResponseDtos.get(0).getCharges());
		Assertions.assertEquals(actual.getBody().get(0).getValidity(),plansResponseDtos.get(0).getValidity());
		Assertions.assertEquals(actual.getBody().get(0).getTalkTimePlan(),plansResponseDtos.get(0).getTalkTimePlan());

	}
}
