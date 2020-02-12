package com.health.care.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.health.care.dto.DoctorDetail;
import com.health.care.dto.PatientRequestDto;
import com.health.care.dto.PatientResponseDto;
import com.health.care.dto.ResponseDto;
import com.health.care.entity.Appointment;
import com.health.care.entity.Doctor;
import com.health.care.entity.Hospital;
import com.health.care.repository.AppointmentRepository;
import com.health.care.repository.DoctorRepository;
import com.health.care.repository.HospitalRepository;

@Service
public class PatientServiceImpl implements PatientService {
	@Autowired
	DoctorRepository doctorRepository;
	
	@Autowired
	HospitalRepository hospitalRepository;
	
	@Autowired
	AppointmentRepository appointmentRepository;

	@Override
	public PatientResponseDto search(String specialization) {
		List<Doctor> doctors = doctorRepository.findBySpecialization(specialization);
		List<DoctorDetail> doctorDetails = new ArrayList<DoctorDetail>();
		doctors.forEach(doctor ->{
			DoctorDetail doctorDetail  = new DoctorDetail();
		Hospital hospital = hospitalRepository.findByDoctorId(doctor.getDoctorId());
		doctorDetail.setHospitalName(hospital.getHospitalName());
		doctorDetail.setDoctorName(doctor.getDoctorName());
		doctorDetail.setDoctorId(doctor.getDoctorId());
		doctorDetail.setMobileNumber(doctor.getMobileNumber());
		doctorDetail.setQualification(doctor.getQualification());
		doctorDetail.setSpecialization(doctor.getSpecialization());
		doctorDetails.add(doctorDetail);
		});
		 PatientResponseDto patientResponseDto = new PatientResponseDto();
		 patientResponseDto.setDoctorDetails(doctorDetails);
		 patientResponseDto.setMessage("List of Doctors");
		 patientResponseDto.setStatusCode(HttpStatus.OK.value());
		 return patientResponseDto;
	}

	
	 
	  public ResponseDto bookAppointment(PatientRequestDto patientRequestDto) { 
		  ResponseDto resposne = new ResponseDto(); Appointment
	  appointment = new Appointment();
	  appointment.setDoctorId(patientRequestDto.getDoctorId());
	  appointment.setPatientContact(patientRequestDto.getPatientContact());
	  appointment.setPatientName(patientRequestDto.getPatientName());
	  appointment.setSlotName(patientRequestDto.getSlotName());
	 // Hospital hospital = hospitalRepository.
	 /* appointmentRepository.save(appointment);
	  resposne.setMessage("Appointment success");
	  resposne.setStatusCode(HttpStatus.ACCEPTED.value());
	  return resposne; */
	return null;
	 }
	 

}


