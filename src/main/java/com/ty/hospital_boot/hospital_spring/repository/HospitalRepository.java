package com.ty.hospital_boot.hospital_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.hospital_boot.hospital_spring.dto.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Integer>{

}
