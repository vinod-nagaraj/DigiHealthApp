package com.health.care.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.health.care.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}
