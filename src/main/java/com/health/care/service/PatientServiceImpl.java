package com.health.care.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.health.care.constant.ApplicationConstants;
import com.health.care.dto.DoctorDetail;
import com.health.care.dto.PatientRequestDto;
import com.health.care.dto.PatientResponseDto;
import com.health.care.dto.ResponseDto;
import com.health.care.entity.Appointment;
import com.health.care.entity.Doctor;
import com.health.care.entity.Hospital;
import com.health.care.entity.Slot;
import com.health.care.exception.HospitalNotFoundException;
import com.health.care.exception.SlotAlreadyBookedException;
import com.health.care.repository.AppointmentRepository;
import com.health.care.repository.DoctorRepository;
import com.health.care.repository.HospitalRepository;

/*
 * Method Performs the patient's operation that includes Search doctor,BookAppointment
 * 
 */
@Service
public class PatientServiceImpl implements PatientService {
	@Autowired
	DoctorRepository doctorRepository;

	@Autowired
	HospitalRepository hospitalRepository;

	@Autowired
	AppointmentRepository appointmentRepository;

	/**
	 * @author Vinod B N
	 * 
	 *         Method Performs the patient's operation that includes Search
	 *         doctor,BookAppointment
	 * 
	 * @param specialization
	 * @return patientResponseDto Displays the List of details along with a status
	 *         code and message
	 **/
	@Override
	public PatientResponseDto search(String specialization) {
		List<Doctor> doctors = doctorRepository.findBySpecialization(specialization);
		List<DoctorDetail> doctorDetails = new ArrayList<>();
		doctors.forEach(doctor -> {
			DoctorDetail doctorDetail = new DoctorDetail();
			Hospital hospital = hospitalRepository.findByDoctorId(doctor.getDoctorId());
			doctorDetail.setHospitalName(hospital.getHospitalName());
			doctorDetail.setDoctorName(doctor.getDoctorName());
			doctorDetail.setDoctorId(doctor.getDoctorId());
			doctorDetail.setMobileNumber(doctor.getMobileNumber());
			doctorDetail.setQualification(doctor.getQualification());
			doctorDetail.setSpecialization(doctor.getSpecialization());
			doctorDetail.setRating(doctor.getRating());
			doctorDetails.add(doctorDetail);
		});
		PatientResponseDto patientResponseDto = new PatientResponseDto();
		patientResponseDto.setDoctorDetails(doctorDetails);
		patientResponseDto.setMessage("List of Doctors");
		patientResponseDto.setStatusCode(HttpStatus.OK.value());
		return patientResponseDto;
	}

	@Override
	public ResponseDto bookAppointment(PatientRequestDto patientRequestDto) {
		ResponseDto resposne = new ResponseDto();
		Appointment appointment = new Appointment();
		appointment.setDoctorId(patientRequestDto.getDoctorId());
		appointment.setPatientContact(patientRequestDto.getPatientContact());
		appointment.setPatientName(patientRequestDto.getPatientName());
		appointment.setSlotName(patientRequestDto.getSlotName());
		Appointment dbappointment = appointmentRepository.findByDoctorIdAndSlotName(patientRequestDto.getDoctorId(),
				patientRequestDto.getSlotName());
		if (!(ObjectUtils.isEmpty(dbappointment))) {
			throw new SlotAlreadyBookedException(ApplicationConstants.SLOT_ALREADY_BOOKED);
		}
		Hospital hospital = hospitalRepository.findByHospitalName(patientRequestDto.getHospitalName());

		if (ObjectUtils.isEmpty(hospital)) {
			throw new HospitalNotFoundException(ApplicationConstants.HOSPITAL_NOT_FOUND);
		}

		List<Slot> slots = hospital.getSlots();
		slots.forEach(slot -> {
			if (slot.getSlotName().equalsIgnoreCase(patientRequestDto.getSlotName())) {
				slot.setStatus(ApplicationConstants.BOOKED);
			}
		});
		hospital.setSlots(slots);
		hospitalRepository.save(hospital);
		appointmentRepository.save(appointment);
		resposne.setMessage("Appointment success");
		resposne.setStatusCode(HttpStatus.ACCEPTED.value());
		return resposne;

	}

}
