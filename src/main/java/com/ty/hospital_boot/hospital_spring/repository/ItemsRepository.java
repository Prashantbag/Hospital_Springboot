package com.ty.hospital_boot.hospital_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.hospital_boot.hospital_spring.dto.Items;

public interface ItemsRepository extends JpaRepository<Items, Integer> {

}
