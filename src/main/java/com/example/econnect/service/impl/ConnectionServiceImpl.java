package com.example.econnect.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.econnect.dto.NumberResponseDto;
import com.example.econnect.dto.PlansResponseDto;
import com.example.econnect.entity.Connection;
import com.example.econnect.entity.Numbers;
import com.example.econnect.entity.Plan;
import com.example.econnect.repository.ConnectionRepository;
import com.example.econnect.repository.ConnectionRequestRepository;
import com.example.econnect.repository.NumberRepository;
import com.example.econnect.repository.PlansRepository;
import com.example.econnect.service.ConnectionService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ConnectionServiceImpl implements ConnectionService {

	@Autowired
	PlansRepository plansRepository;
	@Autowired
	ConnectionRequestRepository connectionRequestRepository;

	@Autowired
	ConnectionRepository connectionRepository;

	@Autowired
	NumberRepository numberRepository;

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

	@Scheduled(fixedRate = 10000)
	public void enableConnection() {
		List<Connection> connection = connectionRepository.findAll();
		Numbers num = null;
		for (Connection connectionEnable : connection) {
			if (connectionEnable.getStatus().equalsIgnoreCase("APPROVED")) {
				connectionEnable.setStatus("CONNECTION ESTABLISHED");
				num = numberRepository.findByMobileNumberId(connectionEnable.getNumber());
				num.setStatus("ALLOTED");
				numberRepository.save(num);
				connectionRepository.save(connectionEnable);

			}

		}
	}

	@Override
	public String connectionStatus(int id) {

		return connectionRepository.findBySubscriber(id).getStatus();

	}

	@Override
	public List<NumberResponseDto> getAllTheNumbers() {
		log.info("List of all mobile numbers");
		List<Numbers> numberResponse = numberRepository.findAll();
		List<NumberResponseDto> listnumberResponseDto = numberResponse.stream().map(listOfNumbers -> {
			NumberResponseDto numberResponseDto = new NumberResponseDto();
			BeanUtils.copyProperties(listOfNumbers, numberResponseDto);
			return numberResponseDto;
		}).collect(Collectors.toList());
		return listnumberResponseDto;
	}

}
