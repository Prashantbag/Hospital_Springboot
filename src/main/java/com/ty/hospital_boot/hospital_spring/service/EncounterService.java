package com.ty.hospital_boot.hospital_spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.hospital_boot.hospital_spring.dao.EncounterDao;
import com.ty.hospital_boot.hospital_spring.dto.Address;
import com.ty.hospital_boot.hospital_spring.dto.Encounter;
import com.ty.hospital_boot.hospital_spring.util.ResponseStructure;

@Service
public class EncounterService {
	@Autowired
	private EncounterDao dao;
	
	
	public ResponseEntity<ResponseStructure<Encounter>> updateAddressById(Encounter encounter,int id){
		ResponseStructure<Encounter> responseStructure=new ResponseStructure<Encounter>();
		ResponseEntity<ResponseStructure<Encounter>> responseEntity=new ResponseEntity<ResponseStructure<Encounter>>(responseStructure,HttpStatus.OK);
		Encounter encounter2=dao.getEncounterById(id);
		if(encounter2!=null) {
			encounter.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("updated");
			responseStructure.setData(dao.saveEncounter(encounter));
		}else {
			throw new NoSuchIdUpdate("No Such Id To Be Updated");
		}
		return responseEntity;
	}
	public ResponseEntity<ResponseStructure<Encounter>> getAddressById(int id){
		ResponseStructure<Encounter> responseStructure=new ResponseStructure<Encounter>();
		ResponseEntity<ResponseStructure<Encounter>> responseEntity=new ResponseEntity<ResponseStructure<Encounter>>(responseStructure,HttpStatus.OK);
		Encounter encounter=dao.getEncounterById(id);
		if(encounter!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("received");
			responseStructure.setData(dao.getEncounterById(id));
		}else {
			throw new NoSuchIdFoundException("No Such Id Found");
		}
		return responseEntity;
	}
	
	
}
