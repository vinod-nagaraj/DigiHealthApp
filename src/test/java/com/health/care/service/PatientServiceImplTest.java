package com.health.care.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.health.care.dto.DoctorDetail;
import com.health.care.dto.DoctorResponseDto;
import com.health.care.dto.PatientRequestDto;
import com.health.care.dto.PatientResponseDto;
import com.health.care.dto.ResponseDto;
import com.health.care.entity.Doctor;
import com.health.care.entity.Hospital;
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

	@Test
	public void search() {
		String specialization = "Surgeon";
		DoctorDetail docDetail1 = new DoctorDetail();
		docDetail1.setDoctorId(1L);
		docDetail1.setDoctorName("Vinod");
		docDetail1.setHospitalName("BSG");
		docDetail1.setMobileNumber("1234567890");
		docDetail1.setQualification("MBBS");
		docDetail1.setRating(5);
		docDetail1.setSpecialization(specialization);
		DoctorDetail docDetail2 = new DoctorDetail();
		docDetail2.setDoctorId(1L);
		docDetail2.setDoctorName("Vinod");
		docDetail2.setHospitalName("BSG");
		docDetail2.setMobileNumber("1234567890");
		docDetail2.setQualification("MBBS");
		docDetail2.setRating(5);
		docDetail2.setSpecialization("Psychiatrist");
		List<DoctorDetail> list = new ArrayList<DoctorDetail>();
		list.add(docDetail1);
		list.add(docDetail2);
		PatientResponseDto resp = new PatientResponseDto();
		resp.setDoctorDetails(list);
		resp.setStatusCode(200);
		resp.setMessage("List of Doctors");
		Hospital hospital = new Hospital();
		Doctor doctor = new Doctor();
		// Mockito.when(doctorRepository.findBySpecialization(specialization).thenReturn(Optional.of(doctor)));
		Mockito.when(hospitalRepository.findByDoctorId(docDetail1.getDoctorId())).thenReturn(hospital);
		PatientResponseDto responseDto = patientServiceImpl.search(specialization);
		assertEquals(200, responseDto.getStatusCode());

	}
	/*
	 * @Test public void bookAppointment() { PatientRequestDto req = new
	 * PatientRequestDto(); req.setDoctorId(1L); req.setHospitalName("BSG");
	 * req.setPatientContact("1234567890"); req.setPatientName("Mukesh");
	 * req.setSlotName("11:00 AM"); Hospital hospital = new Hospital(); ResponseDto
	 * resp = new ResponseDto(); resp.setStatusCode(200);
	 * Mockito.when(hospitalRepository.findByHospitalName(req.getHospitalName())).
	 * thenReturn(hospital); resp = patientServiceImpl.bookAppointment(req);
	 * assertEquals(200, resp.getStatusCode());
	 * 
	 * }
	 */

}
