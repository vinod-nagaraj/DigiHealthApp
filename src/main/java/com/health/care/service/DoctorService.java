package com.health.care.service;

import com.health.care.dto.DoctorRequestDto;
import com.health.care.dto.DoctorResponseDto;
import com.health.care.dto.PatientDetailDto;
import com.health.care.dto.ResponseDto;

public interface DoctorService {

	DoctorResponseDto getSlots(Long doctorId);

	ResponseDto addSlots(DoctorRequestDto doctorRequestDto, Long doctorId);

	PatientDetailDto getPatients(Long doctorId);

}
