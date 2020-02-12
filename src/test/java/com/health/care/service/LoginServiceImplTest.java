package com.health.care.service;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.health.care.dto.LoginRequestDto;
import com.health.care.entity.Doctor;
import com.health.care.exception.NotFoundException;
import com.health.care.repository.DoctorRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class LoginServiceImplTest {
	
	@InjectMocks
	LoginServiceImpl loginServiceImpl;
	
	@Mock
	DoctorRepository doctorRepository;
	
	@Before
	public void before() {

	}
	@Test
	public void authenticateCustomer() throws NotFoundException {
		LoginRequestDto req = new LoginRequestDto();
		LoginRequestDto req1 = new LoginRequestDto();
		Doctor doctor1 = new Doctor();
		doctor1.setMobileNumber("9513090305");
		doctor1.setPassword("r@sid1000");
		doctor1.setMobileNumber("9513090306");
		doctor1.setPassword("vinod123");
		req.setPassword("vinod");
		req.setMobileNumber("9513090306");
		req1.setMobileNumber("9513090305");
		req1.setPassword("r@sid1000");
		Mockito.when(doctorRepository.findByMobileNumberAndPassword(req.getMobileNumber(), req.getPassword())).thenReturn(Optional.of(doctor1));
		
	
		

		
	}

}
