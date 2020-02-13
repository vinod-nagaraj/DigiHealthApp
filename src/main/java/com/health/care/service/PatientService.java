package com.health.care.service;

import com.health.care.dto.PatientRequestDto;
import com.health.care.dto.PatientResponseDto;
import com.health.care.dto.ResponseDto;

public interface PatientService {
	
	PatientResponseDto search (String specialization);

	public ResponseDto bookAppointment(PatientRequestDto patientRequestDto);
}
