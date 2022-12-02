package com.ty.hospital_boot.hospital_spring.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hospital_boot.hospital_spring.dto.Hospital;
import com.ty.hospital_boot.hospital_spring.repository.HospitalRepository;

@Repository
public class HospitalDao {

	@Autowired
	HospitalRepository hospitalRepository;
	
	public Hospital saveHospital(Hospital hospital) {
		return hospitalRepository.save(hospital);
	}
	
	public Hospital getHospitalById(int id) {
		Optional< Hospital> optional=hospitalRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();	
		}else {
			return null;
		}
	}
	
	public String  deleteHospitalById(int id) {
		hospitalRepository.deleteById(id);
		return "deleted";
	}
	
	public Hospital updateHospital(Hospital hospital,int id) {
		Optional<Hospital> optional= hospitalRepository.findById(id);
		Hospital hospital2;
		if(optional.isPresent()) {
			hospital2=optional.get();
		}else {
			hospital2=null;
		}
		
		if(hospital2!=null) {
			hospital.setId(id);
			hospitalRepository.save(hospital);
			return hospital;
		}else {
			return null;
		}
	}
}
