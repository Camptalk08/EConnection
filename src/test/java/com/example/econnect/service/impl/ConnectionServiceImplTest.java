package com.example.econnect.service.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.econnect.dto.PlansResponseDto;
import com.example.econnect.entity.Plan;
import com.example.econnect.repository.PlansRepository;

@SpringBootTest
class ConnectionServiceImplTest {

	@Mock
	PlansRepository plansRepository;

	@InjectMocks
	ConnectionServiceImpl connectionServiceImpl;

	List<Plan> listPlans;

	Plan plan;

	List<PlansResponseDto> plansResponseDtos;

	PlansResponseDto plansResponseDto;

	@BeforeEach
	public void setup() {
		plan = new Plan();
		plan.setTalkTimeId(1);
		plan.setCharges(223);
		plan.setTalkTimePlan("unlimited talk time");
		plan.setValidity(28);
		listPlans = new ArrayList<Plan>();
		listPlans.add(plan);

		plansResponseDto = new PlansResponseDto();
		plansResponseDto.setTalkTimeId(1);
		plansResponseDto.setCharges(223);
		plansResponseDto.setTalkTimePlan("unlimited talk time");
		plansResponseDto.setValidity(28);
		plansResponseDtos = new ArrayList<PlansResponseDto>();
		plansResponseDtos.add(plansResponseDto);

	}

	@Test
	void testUpadateRequestStatus() {
		//WHEN
		Mockito.when(plansRepository.findAll()).thenReturn(listPlans);
		List<PlansResponseDto> actual = connectionServiceImpl.getAllThePlans();
		assertNotNull(actual);
		// THEN
		Assertions.assertEquals(actual.size(), plansResponseDtos.size());

	}

}
