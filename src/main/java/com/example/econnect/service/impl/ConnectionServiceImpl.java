package com.example.econnect.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.econnect.dto.ConnectionRequestDTO;
import com.example.econnect.dto.NumberResponseDto;
import com.example.econnect.dto.PlansResponseDto;
import com.example.econnect.dto.ResponseDTO;
import com.example.econnect.entity.Admin;
import com.example.econnect.entity.Connection;
import com.example.econnect.entity.Numbers;
import com.example.econnect.entity.Plan;
import com.example.econnect.entity.Subscriber;
import com.example.econnect.exception.ConnectionRequestException;
import com.example.econnect.repository.AdminRepository;
import com.example.econnect.repository.ConnectionRepository;
import com.example.econnect.repository.NumbersRepository;
import com.example.econnect.repository.PlanRepository;
import com.example.econnect.repository.RequestRepository;
import com.example.econnect.repository.SubscriberRepository;
import com.example.econnect.service.ConnectionService;
import com.example.econnect.util.Stat;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ConnectionServiceImpl implements ConnectionService {
	@Autowired
	SubscriberRepository subscriberRepository;

	@Autowired
	PlanRepository plansRepository;
	@Autowired
	ConnectionRepository connectionRepository;
	@Autowired
	NumbersRepository numberRepository;
	@Autowired
	AdminRepository adminRepository;
	@Autowired
	RequestRepository repository;

	@Override
	public Optional<ResponseDTO> connectionRequest(ConnectionRequestDTO connectionRequestDTO, int mobileId, int planId) {

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
		connection.setStatus(Stat.IN_PROGRESS.toString());
		connection.setSubcriberId(subscriberEntity.getSubcriberId());
         System.out.println("");
		connectionRepository.save(connection);
		ResponseDTO responseDTO = new ResponseDTO();
		responseDTO.setSubscriberId(subscriberEntity.getSubcriberId());

		return Optional.of(responseDTO);

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

	@Override
	public List<PlansResponseDto> getAllThePlans() {
		log.info("Inside the service implementation  class for getting all the available plans");
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
			if (connectionEnable.getStatus().equals(Stat.APPROVED.toString())) {
				connectionEnable.setStatus(Stat.CONNECTION_ESTABLISH.toString());
				num = numberRepository.findByMobileNumberId(connectionEnable.getMobileNumberId());
				num.setStatus(Stat.ALLOTED.toString());
				numberRepository.save(num);
				connectionRepository.save(connectionEnable);

			}

		}
	}

	@Override
	public String connectionStatus(int id) {
		Optional<Connection> user = connectionRepository.findBySubcriberId(id);
		String status = "";

		if (user.isPresent()) {
			status = user.get().getStatus();
		} else {

			throw new ConnectionRequestException("User do not Exists With This Id");
		}
		return status;

	}

	@Override
	public List<NumberResponseDto> getAllTheNumbers() {
		log.info("Getting all the available mobile numbers");
		List<Numbers> numberResponse = numberRepository.findAll();
		List<NumberResponseDto> listnumberResponseDto = numberResponse.stream()
				.filter(numberAvailable -> numberAvailable.getStatus().equals(Stat.AVAILABLE.toString()))
				.map(listOfNumbers -> {
					NumberResponseDto numberResponseDto = new NumberResponseDto();
					BeanUtils.copyProperties(listOfNumbers, numberResponseDto);
					return numberResponseDto;
				}).collect(Collectors.toList());
		return listnumberResponseDto;
	}

	@Override
	public Integer addAdmin(Admin admin) {
		Admin adminUser = adminRepository.save(admin);
		if (adminUser != null) {
			return adminUser.getAdmin_id();
		} else {
			return null;
		}
	}

	@Override
	public List<Connection> getConnections() {
		return repository.findAll();
	}

	@Override
	public Connection getConnectionRequest(String sub_no) {
//		if (sub_no != null) {
//			return connectionRepository.findBySubcriberId(Integer.parseInt(sub_no));
//		} else {
//			return null;
//		}
		
	Optional<Connection> check=connectionRepository.findBySubcriberId(Integer.parseInt(sub_no));
	Connection con=null;
	if(check.isPresent())
	{
	
		con=check.get();
	}
	else
	{
		throw new ConnectionRequestException("Connection not available");
	}
	return con;
	}

	@Override
	public String updateConnectionStatus(Connection connection) {
		if (connection != null) {
			connectionRepository.save(connection);
			return "success";
		} else {
			return "failed";
		}
	}

}
