package com.health.care.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.health.care.dto.DoctorRequestDto;
import com.health.care.dto.DoctorResponseDto;
import com.health.care.dto.LoginResponseDto;
import com.health.care.dto.ResponseDto;
import com.health.care.dto.SelectedSlot;
import com.health.care.entity.Hospital;
import com.health.care.entity.Slot;
import com.health.care.repository.HospitalRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class DoctorServiceImplTest {

	@InjectMocks
	DoctorServiceImpl doctorServiceImpl;

	@Mock
	HospitalRepository hospitalRepository;

	@Before
	public void before() {

	}

	@Test
	public void getSlots() {
		Long doctorId = 101L;
		Hospital hospital = new Hospital();
		hospital.setDoctorId(101L);
		hospital.setHospitalId(1L);
		hospital.setHospitalName("BSG");
		hospital.setLocation("Bangalore");
		Slot slot1 = new Slot();
		slot1.setSlotName("10.00AM");
		slot1.setStatus("Booked");
		Slot slot2 = new Slot();
		slot2.setSlotName("11.00AM");
		slot2.setStatus("Booked");
		Slot slot3 = new Slot();
		slot3.setSlotName("12.00AM");
		slot3.setStatus("Booked");
		List<Slot> list = new ArrayList<Slot>();
		list.add(slot1);
		list.add(slot2);
		list.add(slot3);
		hospital.setSlots(list);
		Mockito.when(hospitalRepository.findByDoctorId(doctorId)).thenReturn(hospital);
		DoctorResponseDto resp = doctorServiceImpl.getSlots(doctorId);
		assertEquals(200, resp.getStatusCode());

	}
	
	@Test
	public void addSlots()
	{
		Hospital hospital = new Hospital();
		Long doctorId = 101L;
		SelectedSlot selectedSlot1 = new SelectedSlot();
		selectedSlot1.setAvailablity(true);
		selectedSlot1.setSlotName("10.00AM");
		SelectedSlot selectedSlot2 = new SelectedSlot();
		selectedSlot2.setAvailablity(true);
		selectedSlot2.setSlotName("11.00AM");
		SelectedSlot selectedSlot3 = new SelectedSlot();
		selectedSlot3.setAvailablity(true);
		selectedSlot3.setSlotName("09.00AM");
		List<SelectedSlot> list = new ArrayList<SelectedSlot>();
		list.add(selectedSlot1);
		list.add(selectedSlot2);
		list.add(selectedSlot3);
		DoctorRequestDto req = new DoctorRequestDto();
		req.setSelectedslots(list);
		Mockito.when(hospitalRepository.findByDoctorId(doctorId)).thenReturn(hospital);
		ResponseDto resp = doctorServiceImpl.addSlots(req, doctorId);
		assertEquals(200, resp.getStatusCode());
		
		
		
		
	}
	

}
