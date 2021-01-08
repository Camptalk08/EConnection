package com.example.econnect.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.econnect.dto.NumberResponseDto;
import com.example.econnect.dto.PlansResponseDto;
import com.example.econnect.entity.Numbers;
import com.example.econnect.entity.Plan;
import com.example.econnect.repository.NumberRepository;
import com.example.econnect.repository.PlansRepository;

@RunWith(MockitoJUnitRunner.class)
class ConnectionServiceImplTest {

	@InjectMocks
	ConnectionServiceImpl connectionServiceImpl;

	@Mock
	PlansRepository plansRepository;
	
	@Mock
	NumberRepository numberRepository;

	@Test
	public void getAllThePlansTest() {
		List<Plan> planList = new ArrayList<>();
		Plan plan = new Plan();
		plan.setTalkTimeId(1);
		plan.setTalkTimePlan("PLAN 1");
		plan.setCharges(50);
		plan.setValidity(1);
		planList.add(plan);

		Mockito.when(plansRepository.findAll()).thenReturn(planList);
		List<PlansResponseDto> actualListPlan = connectionServiceImpl.getAllThePlans();

		Assert.assertEquals(planList.size(), actualListPlan.size());

	}
	
	
	@Test
	public void getNumberTest()
	{
		List<Numbers> numList = new ArrayList<>();
		Numbers num=new Numbers();
		num.setMobileNumberId(1);
		num.setMobileNumber(8998L);
		num.setStatus("AVAILABLE");
		numList.add(num);
		Mockito.when(numberRepository.findAll()).thenReturn(numList);
		List<NumberResponseDto> actual=connectionServiceImpl.getAllTheNumbers();
		Assert.assertEquals(numList.size(), actual.size());

	}

}
