package com.ty.hospital_boot.hospital_spring.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hospital_boot.hospital_spring.dto.Encounter;
import com.ty.hospital_boot.hospital_spring.repository.EncounterRepository;

@Repository
public class EncounterDao {

	@Autowired
	EncounterRepository encounterRepository;
	
	public Encounter getEncounterById(int id) {
		Optional<Encounter> optional=encounterRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return  null;
		}
	}
	
	public Encounter updateEncounter(Encounter encounter,int id) {
		Optional<Encounter> optional=encounterRepository.findById(id);
		Encounter encounter2;
		if(optional.isPresent()) {
			 encounter2= optional.get();
		}else {
			 encounter2= null;
		}
		
		if( encounter2!=null) {
			 encounter.setId(id);
			 encounterRepository.save( encounter);
			return  encounter;
		}else {
			return null;
		}
		
	}
	
	public Encounter saveEncounter(Encounter encounter) {
		
		return encounterRepository.save(encounter);
	}
}
