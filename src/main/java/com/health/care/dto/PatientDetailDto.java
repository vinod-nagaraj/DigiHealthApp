package com.health.care.dto;

import java.util.List;

public class PatientDetailDto {
	
	private int statusCode;
	private List<PatientDetail> patientDetails;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public List<PatientDetail> getPatientDetails() {
		return patientDetails;
	}
	public void setPatientDetails(List<PatientDetail> patientDetails) {
		this.patientDetails = patientDetails;
	}

}
