package com.health.care.service;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.health.care.constant.ApplicationConstants;
import com.health.care.dto.LoginRequestDto;
import com.health.care.dto.LoginResponseDto;
import com.health.care.entity.Doctor;
import com.health.care.exception.NotFoundException;
import com.health.care.repository.DoctorRepository;

/**
 * 
 * @author Raghib
 * 
 *         Login Service has the implementations for Login related api's.
 * 
 *
 */

@Service
public class LoginServiceImpl implements LoginService {
	private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

	@Autowired
	DoctorRepository doctorRepository;

	@Override
	public LoginResponseDto authenticateCustomer(LoginRequestDto loginRequestDto) throws NotFoundException {
		logger.info("LoginServiceImpl authenticateCustomer ---> autheticating customer");
		
		Optional<Doctor> doctor = doctorRepository.findByMobileNumberAndPassword(loginRequestDto.getMobileNumber(),
				loginRequestDto.getPassword());

		if (doctor.isPresent()) {
			LoginResponseDto loginResponseDto = new LoginResponseDto();
			BeanUtils.copyProperties(doctor.get(), loginResponseDto);
			loginResponseDto.setDoctorName(doctor.get().getDoctorName());
			loginResponseDto.setDoctorId(doctor.get().getDoctorId());
			loginResponseDto.setStatusCode(ApplicationConstants.SUCCESS_CODE);
			logger.info("LoginServiceImpl authenticateCustomer ---> Doctor signed in");
			return loginResponseDto;
		} else {
			logger.error("LoginServiceImpl authenticateCustomer ---> NotFoundException occured");
			throw new NotFoundException(ApplicationConstants.USER_NOT_FOUND);
			
		}

	}

}
