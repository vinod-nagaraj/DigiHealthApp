package com.health.care.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.health.care.dto.DoctorDetail;
import com.health.care.dto.PatientRequestDto;
import com.health.care.dto.PatientResponseDto;
import com.health.care.dto.ResponseDto;
import com.health.care.service.PatientService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class PatientControllerTest {
	
	@InjectMocks
	PatientController patientController;
	
	@Mock
	PatientService patientService;
	
	@Test
	public void search() {
		String specialization = "surgeon";
		PatientResponseDto res = new PatientResponseDto();
		DoctorDetail doctorDetail1 = new DoctorDetail();
		doctorDetail1.setDoctorId(1L);
		doctorDetail1.setDoctorName("vinod");
		doctorDetail1.setHospitalName("BGS");
		doctorDetail1.setMobileNumber("838378");
		doctorDetail1.setQualification("MBBS");
		doctorDetail1.setRating(5);
		doctorDetail1.setSpecialization("surgeon");
		DoctorDetail doctorDetail2 = new DoctorDetail();
		doctorDetail2.setDoctorId(1L);
		doctorDetail2.setDoctorName("vinod");
		doctorDetail2.setHospitalName("BGS");
		doctorDetail2.setMobileNumber("838378");
		doctorDetail2.setQualification("MBBS");
		doctorDetail2.setRating(5);
		doctorDetail2.setSpecialization("surgeon");
		List<DoctorDetail> list = new ArrayList<DoctorDetail>();
		res.setDoctorDetails(list);
		res.setStatusCode(202);
		res.setMessage("Done");
		Mockito.when(patientService.search(specialization)).thenReturn(res);
		assertEquals(202, res.getStatusCode());
	}
	@Test
	public void bookAppointment() {
		PatientRequestDto req = new PatientRequestDto();
		req.setDoctorId(1L);
		req.setHospitalName("BSG");
		req.setPatientContact("123476768");
		req.setPatientName("Mukesh");
		req.setSlotName("10:00 AM");
		
		ResponseDto resp = new ResponseDto();
		resp.setStatusCode(200);
		resp.setMessage("Done");
		Mockito.when(patientService.bookAppointment(req)).thenReturn(resp);
		assertNotNull(req);
		
		
		
		
		
	}
	
	

}
