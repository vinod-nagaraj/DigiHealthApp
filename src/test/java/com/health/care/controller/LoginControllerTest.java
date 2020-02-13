package com.health.care.controller;


import static org.junit.jupiter.api.Assertions.assertEquals;

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
		res.setStatusCode(200);
		req.setPassword("vinod");
		req.setMobileNumber("9513090306");
		req1.setMobileNumber("9513090305");
		req1.setPassword("r@sid1000");
		Mockito.when(loginService.authenticateCustomer(req)).thenReturn(res);
		assertEquals(200, res.getStatusCode());

	}


}
