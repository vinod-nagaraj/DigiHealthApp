package com.health.care.service;

import com.health.care.dto.LoginRequestDto;
import com.health.care.dto.LoginResponseDto;
import com.health.care.exception.NotFoundException;

public interface LoginService {

	public LoginResponseDto authenticateCustomer(LoginRequestDto loginRequestDto) throws NotFoundException;

}
