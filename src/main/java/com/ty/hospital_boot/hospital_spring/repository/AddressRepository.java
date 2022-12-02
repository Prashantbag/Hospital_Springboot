package com.ty.hospital_boot.hospital_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.hospital_boot.hospital_spring.dto.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{

}
