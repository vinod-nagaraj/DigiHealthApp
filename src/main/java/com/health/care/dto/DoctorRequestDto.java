package com.health.care.dto;

import java.util.ArrayList;
import java.util.List;

public class DoctorRequestDto {
	
	private List<SelectedSlot> selectedslots= new ArrayList<>();

	public List<SelectedSlot> getSelectedslots() {
		return selectedslots;
	}

	public void setSelectedslots(List<SelectedSlot> selectedslots) {
		this.selectedslots = selectedslots;
	}

}
