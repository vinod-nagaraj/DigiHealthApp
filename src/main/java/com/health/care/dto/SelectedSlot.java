package com.health.care.dto;

public class SelectedSlot {
	
	private String slotName;
	private String status;
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private Boolean availablity;
	

	public Boolean getAvailablity() {
		return availablity;
	}

	public void setAvailablity(Boolean availablity) {
		this.availablity = availablity;
	}

	public String getSlotName() {
		return slotName;
	}

	public void setSlotName(String slotName) {
		this.slotName = slotName;
	}

}
