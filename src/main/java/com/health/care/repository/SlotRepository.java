package com.health.care.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.health.care.entity.Slot;

public interface SlotRepository extends JpaRepository<Slot, Long>{

}
