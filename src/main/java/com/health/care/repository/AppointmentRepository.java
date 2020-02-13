package com.health.care.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.health.care.entity.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long>{

	Appointment findBySlotName(String slotName);

	Appointment findByDoctorIdAndSlotName(Long doctorId, String slotName);

}
