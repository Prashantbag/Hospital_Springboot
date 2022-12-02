package com.ty.hospital_boot.hospital_spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.hospital_boot.hospital_spring.dao.HospitalDao;
import com.ty.hospital_boot.hospital_spring.dto.Hospital;
import com.ty.hospital_boot.hospital_spring.util.ResponseStructure;

@Service
public class HospitalService {
	@Autowired
	private HospitalDao dao;

	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(Hospital hospital){
		ResponseStructure<Hospital> responseStructure=new ResponseStructure<Hospital>();
		ResponseEntity<ResponseStructure<Hospital>> responseEntity=new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.OK);
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("saved");
		responseStructure.setData(dao.saveHospital(hospital));
		return responseEntity;
	}
	public ResponseEntity<ResponseStructure<Hospital>> updateHospitalById(Hospital hospital,int id){
		ResponseStructure<Hospital> responseStructure=new ResponseStructure<Hospital>();
		ResponseEntity<ResponseStructure<Hospital>> responseEntity=new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.OK);
		Hospital hospital2=dao.getHospitalById(id);
		if(hospital2!=null) {
			hospital.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Updated");
			responseStructure.setData(hospital);
		}else {
			throw new NoSuchIdUpdate("No Such Id To Be Updated");
		}
		return responseEntity;
	}
	public ResponseEntity<ResponseStructure<Hospital>> getHospitalById(int id){
		ResponseStructure<Hospital> responseStructure=new ResponseStructure<Hospital>();
		ResponseEntity<ResponseStructure<Hospital>> responseEntity=new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.OK);
		Hospital hospital=dao.getHospitalById(id);
		if(hospital!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("received");
			responseStructure.setData(dao.getHospitalById);
		}else {
			throw new NoSuchIdFoundException("No Such Id Found");
			}
		return responseEntity;
	}
	public ResponseEntity<ResponseStructure<Hospital>> deleteHospitalById(int id){
		ResponseStructure<Hospital> responseStructure=new ResponseStructure<Hospital>();
		ResponseEntity<ResponseStructure<Hospital>> responseEntity=new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.OK);
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("deleted");
		responseStructure.setData(dao.deleteHospitalById);
	return responseEntity;
	}


}
