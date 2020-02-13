package com.health.care.dto;

public class SlotDetail {

	private String slotName;
	private String status;
	private Boolean availablity;
	public Boolean getAvailablity() {
		return availablity;
	}
	public void setAvailablity(Boolean availablity) {
		this.availablity = availablity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSlotName() {
		return slotName;
	}
	public void setSlotName(String slotName) {
		this.slotName = slotName;
	}
	
	
}
