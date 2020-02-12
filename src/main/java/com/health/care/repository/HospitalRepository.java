package com.health.care.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.health.care.entity.Hospital;
@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {
	
	Hospital findByDoctorId(Long doctorId);
	
	Hospital findByHospitalName(String hospitalName);



}
