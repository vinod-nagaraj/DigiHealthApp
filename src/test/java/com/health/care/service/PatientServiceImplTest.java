package com.health.care.service;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.health.care.repository.DoctorRepository;
import com.health.care.repository.HospitalRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class PatientServiceImplTest {
	
	@InjectMocks
	PatientServiceImpl patientServiceImpl;
	
	@Mock
	DoctorRepository doctorRepository;
	@Mock
	HospitalRepository hospitalRepository;

	

}
