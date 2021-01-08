package com.example.econnect.service.impl;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.econnect.dto.ConnectionRequestDTO;
import com.example.econnect.dto.ResponseDTO;
import com.example.econnect.entity.Connection;
import com.example.econnect.entity.Subscriber;
import com.example.econnect.exception.ConnectionRequestException;
import com.example.econnect.repository.ConnectionRepository;
import com.example.econnect.repository.SubscriberRepository;
import com.example.econnect.service.ConnectionService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ConnectionServiceImpl implements ConnectionService {
	@Autowired
	SubscriberRepository subscriberRepository;

	@Autowired
	ConnectionRepository connectionRepository;

	@Override
	public ResponseDTO connectionRequest(ConnectionRequestDTO connectionRequestDTO, int mobileId, int planId) {

		Subscriber subscriber = new Subscriber();
		BeanUtils.copyProperties(connectionRequestDTO, subscriber);

		if (!emailValidater(connectionRequestDTO.getEmail())) {
			throw new ConnectionRequestException("Invalid Email");
		}
		if (!phoneNumberValidation(connectionRequestDTO.getAlternateMobileNumber().toString())) {
			throw new ConnectionRequestException("Invalid MobileNo");

		}
		Optional<Subscriber> optSubscriber = subscriberRepository.findByEmail(connectionRequestDTO.getEmail());

		if (optSubscriber.isPresent()) {
			throw new ConnectionRequestException("User Already Exists With This Email");
		}
		Optional<Connection> optConnection = connectionRepository.findByMobileNumberId(mobileId);

		if (optConnection.isPresent()) {
			throw new ConnectionRequestException("Sorry this mobile number is not available");
		}

		Subscriber subscriberEntity = subscriberRepository.save(subscriber);
		Connection connection = new Connection();

		connection.setMobileNumberId(mobileId);
		connection.setTalkTimeId(planId);
		connection.setRemarks("");
		connection.setStatus("Inprogress");
		connection.setSubcriberId(subscriberEntity.getSubcriberId());

		connectionRepository.save(connection);
		ResponseDTO responseDTO=new ResponseDTO();
		responseDTO.setSubscriberId(subscriberEntity.getSubcriberId());
		
		return responseDTO;

	}

	private boolean emailValidater(String email) {

		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"

				+ "A-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);

		if (email == null)

			return false;

		return pat.matcher(email).matches();
	}

	private boolean phoneNumberValidation(String number) {

		Pattern p = Pattern.compile("^[0-9]{10}$");

		Matcher m = p.matcher(number);

		return (m.find() && m.group().equals(number));

	}

}
