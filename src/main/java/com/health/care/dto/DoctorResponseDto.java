package com.health.care.dto;

import java.util.List;

public class DoctorResponseDto {
	
	private Integer statusCode;
	private String message;
	private List<SlotDetail> slotDetails;
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<SlotDetail> getSlotDetails() {
		return slotDetails;
	}
	public void setSlotDetails(List<SlotDetail> slotDetails) {
		this.slotDetails = slotDetails;
	}

}
