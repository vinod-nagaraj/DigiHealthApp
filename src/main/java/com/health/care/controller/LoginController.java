package com.health.care.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.health.care.dto.LoginRequestDto;
import com.health.care.dto.LoginResponseDto;
import com.health.care.exception.NotFoundException;
import com.health.care.service.LoginService;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RestController
@RequestMapping("/login")
@Slf4j
public class LoginController {

	/**
	 * This will inject all the implementations in the loginService.
	 */
	@Autowired
	LoginService loginService;

	/**
	 * @author Raghib
	 * 
	 *         this API is used to authenticate the User
	 * 
	 * @param mobileNumber & Password of Doctor will be used for Login.
	 * @return statusCode,userName,userId.
	 * @throws NotFoundException
	 * 
	 */

	@PostMapping
	public ResponseEntity<LoginResponseDto> authenticateCustomer(@Valid @RequestBody LoginRequestDto loginRequestDto)
			 {
		
		return ResponseEntity.ok().body(loginService.authenticateCustomer(loginRequestDto));
	}

}
