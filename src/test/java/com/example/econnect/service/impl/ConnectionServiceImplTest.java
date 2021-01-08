package com.example.econnect.service.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

//Mockito.when(connectionRepository.save(Mockito.any())).thenReturn(connection);

import org.springframework.boot.test.context.SpringBootTest;

import com.example.econnect.dto.NumberResponseDto;
import com.example.econnect.dto.PlansResponseDto;
import com.example.econnect.entity.Numbers;
import com.example.econnect.entity.Plan;
import com.example.econnect.repository.NumbersRepository;
import com.example.econnect.repository.PlanRepository;

@SpringBootTest
class ConnectionServiceImplTest {

	@InjectMocks
	ConnectionServiceImpl connectionServiceImpl;

	@Mock
	PlanRepository plansRepository;

	@Mock
	NumbersRepository numberRepository;

	List<PlansResponseDto> plansResponseDtos;

	PlansResponseDto plansResponseDto;

	List<Plan> listPlans;

	Plan plan;

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
	public void getNumberTest() {
		List<Numbers> numList = new ArrayList<>();
		Numbers num = new Numbers();
		num.setMobileNumberId(1);
		num.setMobileNumber(8998L);
		num.setStatus("AVAILABLE");
		numList.add(num);
		Mockito.when(numberRepository.findAll()).thenReturn(numList);
		List<NumberResponseDto> actual = connectionServiceImpl.getAllTheNumbers();
		Assert.assertEquals(numList.size(), actual.size());

	}

	@Test
	void testGetAllThePlans() {
		// WHEN
		Mockito.when(plansRepository.findAll()).thenReturn(listPlans);
		List<PlansResponseDto> actual = connectionServiceImpl.getAllThePlans();
		assertNotNull(actual);
		// THEN
		Assertions.assertEquals(actual.size(), plansResponseDtos.size());

	}

}
