package com.health.care.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.care.constant.ApplicationConstants;
import com.health.care.dto.DoctorRequestDto;
import com.health.care.dto.DoctorResponseDto;
import com.health.care.dto.PatientDetail;
import com.health.care.dto.PatientDetailDto;
import com.health.care.dto.ResponseDto;
import com.health.care.dto.SelectedSlot;
import com.health.care.dto.SlotDetail;
import com.health.care.entity.Appointment;
import com.health.care.entity.Hospital;
import com.health.care.entity.Slot;
import com.health.care.repository.AppointmentRepository;
import com.health.care.repository.HospitalRepository;
/**
 * 
 * @author Karthika T
 * @version 1.0
 *
 */
@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private HospitalRepository hospitalRepository;
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	/**
	 * 
	 * Method used to retrieve slots selected by the doctor
	 * 
	 */
	@Override
	public DoctorResponseDto getSlots(Long doctorId) {
		Hospital hospital=hospitalRepository.findByDoctorId(doctorId);
		List<Slot> slots=hospital.getSlots();
		DoctorResponseDto doctorResponseDto=new DoctorResponseDto();
		if(slots.isEmpty()) {
			doctorResponseDto.setStatusCode(ApplicationConstants.NOT_FOUND);
			doctorResponseDto.setMessage(ApplicationConstants.SLOT_NOAVAIL_MSG);
			doctorResponseDto.setSlotDetails(null);
		}else
		{
		List<SlotDetail> slotDetails=new ArrayList<>();
		slots.forEach(slot->{
			SlotDetail slotDetail = new SlotDetail();
			BeanUtils.copyProperties(slot, slotDetail);
			slotDetails.add(slotDetail);
		});
		doctorResponseDto.setStatusCode(ApplicationConstants.SUCCESS_CODE);
		doctorResponseDto.setMessage(ApplicationConstants.SLOT_SUCCESS_MSG);
		doctorResponseDto.setSlotDetails(slotDetails);
		}
		return doctorResponseDto;
	}
	/**
	 * 
	 * Method used to add slots selected by the doctor
	 * 
	 */
	@Override
	public ResponseDto addSlots(DoctorRequestDto doctorRequestDto, Long doctorId) {
		Hospital hospital=hospitalRepository.findByDoctorId(doctorId);
		List<Slot> slots= new ArrayList<>();
		List<SelectedSlot> selectedSlots=doctorRequestDto.getSelectedslots();
		selectedSlots.forEach(selectedSlot->{
			
				Slot slot= new Slot();
				slot.setSlotName(selectedSlot.getSlotName());
				slot.setAvailablity(selectedSlot.getAvailablity());
				slots.add(slot);
			
		});
		hospital.setSlots(slots);
		
		hospitalRepository.save(hospital);
		ResponseDto responseDto= new ResponseDto();
		responseDto.setStatusCode(ApplicationConstants.SUCCESS_CODE);
		responseDto.setMessage(ApplicationConstants.ADD_SLOT_SUCCESS_MSG);
		return responseDto;
	}
	@Override
	public PatientDetailDto getPatients(Long doctorId) {
		Hospital hospital=hospitalRepository.findByDoctorId(doctorId);
		PatientDetailDto patientDetailDto=new PatientDetailDto();
		List<PatientDetail> patientDetails= new ArrayList<>();
		
		List<Slot> slots=hospital.getSlots();
		slots.forEach(slot->{
			PatientDetail patientDetail= new PatientDetail();
			if(slot.getStatus().equalsIgnoreCase(ApplicationConstants.BOOKED)) {
			Appointment app=appointmentRepository.findBySlotName(slot.getSlotName());
			patientDetail.setPatientContact(app.getPatientContact());
			patientDetail.setPatientName(app.getPatientName());
			patientDetail.setSlotName(app.getSlotName());
			patientDetails.add(patientDetail);
			}
		});
		patientDetailDto.setPatientDetails(patientDetails);
		patientDetailDto.setStatusCode(ApplicationConstants.SUCCESS_CODE);
		return patientDetailDto;
	}

}
