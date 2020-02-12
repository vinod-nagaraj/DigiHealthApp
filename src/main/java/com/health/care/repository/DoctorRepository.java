package com.health.care.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.health.care.entity.Doctor;
@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
	
	 List findBySpecialization(String specialization);

}
