package com.health.care.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.health.care.dto.DoctorRequestDto;
import com.health.care.dto.DoctorResponseDto;
import com.health.care.dto.ResponseDto;
import com.health.care.dto.SelectedSlot;
import com.health.care.service.DoctorService;


@RunWith(MockitoJUnitRunner.Silent.class)
public class DoctorControllerTest {
	
	@InjectMocks
	DoctorController doctorController;

	@Mock
	DoctorService doctorService;

	@Before
	public void before() {

	}
	@Test
	public void getSlots()
	{
		Long doctorId = 101L;
		DoctorResponseDto resp = new DoctorResponseDto();
		resp.setStatusCode(200);
		Mockito.when(doctorService.getSlots(doctorId)).thenReturn(resp);
		assertEquals(200, resp.getStatusCode());
		
	}
	@Test
	public void addSlots()
	{
		Long doctorId= 101L;
		SelectedSlot selectedSlot1 = new SelectedSlot();
		selectedSlot1.setAvailablity(true);
		selectedSlot1.setSlotName("10.00AM");
		List<SelectedSlot> list = new ArrayList<SelectedSlot>();
		list.add(selectedSlot1);
		DoctorRequestDto req = new DoctorRequestDto();
		req.setSelectedslots(list);
		ResponseDto resp = new ResponseDto();
		resp.setStatusCode(200);
		Mockito.when(doctorService.addSlots(req, doctorId)).thenReturn(resp);
		assertEquals(200, resp.getStatusCode());
		
	}
	
	
}
