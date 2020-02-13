package com.health.care.dto;

import javax.validation.constraints.NotBlank;

import com.health.care.constant.ApplicationConstants;


public class LoginRequestDto {
	
	@NotBlank(message=ApplicationConstants.MOBILE_NOT_FOUND)
	private String mobileNumber;
	@NotBlank(message=ApplicationConstants.PASSWORD_NOT_FOUND)
	private String password;
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
