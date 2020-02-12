package com.health.care.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.health.care.dto.LoginRequestDto;
import com.health.care.dto.LoginResponseDto;
import com.health.care.exception.NotFoundException;
import com.health.care.service.LoginService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class LoginControllerTest {

	@InjectMocks
	LoginController loginController;

	@Mock
	LoginService loginService;

	@Before
	public void before() {

	}

	@Test
	public void authenticateCustomer() throws NotFoundException {
		LoginRequestDto req = new LoginRequestDto();
		LoginRequestDto req1 = new LoginRequestDto();
		LoginResponseDto res = new LoginResponseDto();
		/*
		 * Doctor doctor1 = new Doctor(); doctor1.setMobileNumber("9513090305");
		 * doctor1.setPassword("r@sid1000"); doctor1.setMobileNumber("9513090306");
		 * doctor1.setPassword("vinod123");
		 */
		req.setPassword("vinod");
		req.setMobileNumber("9513090306");
		req1.setMobileNumber("9513090305");
		req1.setPassword("r@sid1000");
		Mockito.when(loginService.authenticateCustomer(req)).thenReturn(res);

	}
	
	@Test(expected = NotFoundException.class)
	public void testMobileNumberMissing() throws NotFoundException
	{
		LoginRequestDto req = new LoginRequestDto();
		/*
		 * LoginResponseDto res = new LoginResponseDto(); req.setPassword("vinod");
		 * req.setMobileNumber("9513090306");
		 */
		loginController.authenticateCustomer(req);
		//Mockito.when(loginService.authenticateCustomer(req)).thenReturn(res);	
	}
	
	@Test(expected = NotFoundException.class)
	public void testPasswordMissing() throws NotFoundException
	{
		LoginRequestDto req = new LoginRequestDto();
		/*
		 * LoginResponseDto res = new LoginResponseDto(); req.setPassword("vinod");
		 * req.setMobileNumber("9513090306");
		 */
		loginController.authenticateCustomer(req);
		//Mockito.when(loginService.authenticateCustomer(req)).thenReturn(res);	
	}

}
