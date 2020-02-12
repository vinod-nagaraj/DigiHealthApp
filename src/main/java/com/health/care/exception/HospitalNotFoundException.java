package com.health.care.exception;

public class HospitalNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	 public HospitalNotFoundException(String exception) {
		
		super(exception);
	}
}
