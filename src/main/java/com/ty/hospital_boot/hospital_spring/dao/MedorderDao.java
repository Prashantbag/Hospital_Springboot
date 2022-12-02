package com.ty.hospital_boot.hospital_spring.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hospital_boot.hospital_spring.dto.Medorder;
import com.ty.hospital_boot.hospital_spring.repository.MedorderRepository;

@Repository
public class MedorderDao {

	@Autowired
	MedorderRepository medorderRepository;
	
	public Medorder getMedorderById(int id) {
		Optional< Medorder> optional=medorderRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}
}
