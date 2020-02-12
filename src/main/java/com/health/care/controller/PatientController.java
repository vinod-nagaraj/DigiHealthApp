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

import com.health.care.dto.PatientRequestDto;
import com.health.care.dto.PatientResponseDto;
import com.health.care.dto.ResponseDto;
import com.health.care.service.PatientService;

@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RequestMapping("/patients")
public class PatientController {
	
	@Autowired
	PatientService patientService;
	
	
	@GetMapping("/{specialization}")
	public PatientResponseDto search(@PathVariable String specialization) {
		PatientResponseDto patientResponseDto = patientService.search(specialization);
		patientResponseDto.setMessage("List of Details");
		patientResponseDto.setStatusCode(HttpStatus.OK.value());
		return patientResponseDto;
	}
	
	@PostMapping("/appointments")
	 public ResponseEntity<ResponseDto> bookAppointment(@RequestBody PatientRequestDto patientRequestDto) {
		ResponseDto responseDto=patientService.bookAppointment(patientRequestDto);
		return new ResponseEntity<>(responseDto,HttpStatus.OK);
	}
}
