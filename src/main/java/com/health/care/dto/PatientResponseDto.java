package com.health.care.dto;

import java.util.List;

public class PatientResponseDto {

	List<DoctorDetail> doctorDetails;
	private String message;
	private int statusCode;

	public List<DoctorDetail> getDoctorDetails() {
		return doctorDetails;
	}

	public void setDoctorDetails(List<DoctorDetail> doctorDetails) {
		this.doctorDetails = doctorDetails;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

}
