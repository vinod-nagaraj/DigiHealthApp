package com.health.care.dto;

public class ResponseDto {
	

	private String message;
	private int statusCode;

	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}



}
