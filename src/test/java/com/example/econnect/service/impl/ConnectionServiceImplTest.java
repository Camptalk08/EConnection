package com.example.econnect.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.econnect.dto.PlansResponseDto;
import com.example.econnect.entity.Plan;
import com.example.econnect.repository.PlansRepository;


@RunWith(MockitoJUnitRunner.class)
class ConnectionServiceImplTest {
	
	
	@InjectMocks
	ConnectionServiceImpl connectionServiceImpl;

	@Mock
	PlansRepository plansRepository;
	
	
	Plan plan;
	List<Plan> planList=new ArrayList<>();
	
	@Before
	public void setup() {
		plan=new Plan();
		plan.setTalkTimeId(1);
		plan.setTalkTimePlan("PLAN 1");
		plan.setCharges(50);
		plan.setValidity(1);
		planList.add(plan);
		
	}
	
	@Test
	void getAllThePlansTest() {
		
		
	Mockito.when(plansRepository.findAll()).thenReturn(planList);
	List<PlansResponseDto>	actualListPlan=connectionServiceImpl.getAllThePlans();
	
	Assert.assertEquals(planList.size(), actualListPlan.size());
	
	}

}
