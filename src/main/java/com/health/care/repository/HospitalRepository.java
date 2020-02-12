package com.health.care.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.health.care.entity.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {

}
