package com.health.care.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.health.care.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long>{

}
