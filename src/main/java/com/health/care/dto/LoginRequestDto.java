package com.health.care.dto;

import javax.validation.constraints.NotBlank;

import com.health.care.constant.ApplicationConstants;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDto {
	
	@NotBlank(message=ApplicationConstants.MOBILE_NOT_FOUND)
	private String mobileNumber;
	@NotBlank(message=ApplicationConstants.PASSWORD_NOT_FOUND)
	private String password;
	
}
