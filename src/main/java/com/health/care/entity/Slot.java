package com.health.care.entity;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Embeddable
public class Slot {

	private String slotName;
	private String status;
	public String getSlotName() {
		return slotName;
	}
	public void setSlotName(String slotName) {
		this.slotName = slotName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
