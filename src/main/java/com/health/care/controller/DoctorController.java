package com.health.care.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.health.care.dto.DoctorRequestDto;
import com.health.care.dto.DoctorResponseDto;
import com.health.care.dto.PatientDetailDto;
import com.health.care.dto.ResponseDto;
import com.health.care.service.DoctorService;
/**
 * 
 * @author Karthika T
 * @version 1.0
 *
 */
@RestController
@RequestMapping("/doctors")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	/**
	 * @param doctorId of Doctor
	 * @return DoctorResponseDto as response
	 */
	@GetMapping("/{doctorId}/slots")
	public ResponseEntity<DoctorResponseDto> getSlots(@PathVariable Long doctorId) {
		DoctorResponseDto doctorResponseDto=doctorService.getSlots(doctorId);
		return new ResponseEntity<DoctorResponseDto>(doctorResponseDto, HttpStatus.OK);
	}
	
	/**
	 * @param doctorId of Doctor
	 * @return ResponseDto as response
	 */
	@PostMapping("/{doctorId}/slots")
	public ResponseEntity<ResponseDto> addSlots(@RequestBody DoctorRequestDto doctorRequestDto, @PathVariable Long doctorId) {
		ResponseDto responseDto=doctorService.addSlots(doctorRequestDto,doctorId);
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
	}
	/**
	 * @param doctorId of Doctor
	 * @return PatientDetailDto as response
	 */
	@GetMapping("/{doctorId}/patients")
	public ResponseEntity<PatientDetailDto> getPatients(@PathVariable Long doctorId) {
		PatientDetailDto patientDetailDto=doctorService.getPatients(doctorId);
		return new ResponseEntity<PatientDetailDto>(patientDetailDto, HttpStatus.OK);
	}

}
