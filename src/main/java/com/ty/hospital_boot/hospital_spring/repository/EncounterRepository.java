package com.ty.hospital_boot.hospital_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.hospital_boot.hospital_spring.dto.Encounter;

public interface EncounterRepository extends JpaRepository<Encounter, Integer>{

}
