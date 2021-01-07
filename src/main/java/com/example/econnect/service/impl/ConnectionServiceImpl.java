package com.example.econnect.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.econnect.dto.PlansResponseDto;
import com.example.econnect.entity.Plan;
import com.example.econnect.repository.PlansRepository;
import com.example.econnect.service.ConnectionService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ConnectionServiceImpl implements ConnectionService {
	@Autowired
	PlansRepository plansRepository;

	@Override
	public List<PlansResponseDto> getAllThePlans() {
		log.info("Inside get all plans method which shows all the available plans");
		List<Plan> plansResponse = plansRepository.findAll();
		List<PlansResponseDto> listplansResponseDtos = plansResponse.stream().map(listOfPlans -> {
			PlansResponseDto plansResponseDto = new PlansResponseDto();
			BeanUtils.copyProperties(listOfPlans, plansResponseDto);
			return plansResponseDto;
		}).collect(Collectors.toList());
		return listplansResponseDtos;
	}

}
