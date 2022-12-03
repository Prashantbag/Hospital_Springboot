package com.ty.hospital_boot.hospital_spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.hospital_boot.hospital_spring.dao.HospitalDao;
import com.ty.hospital_boot.hospital_spring.dto.Hospital;
import com.ty.hospital_boot.hospital_spring.exception.NoSuchIdFoundException;
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
			throw new NoSuchIdFoundException("No Such Id To Be Updated");
		}
		return responseEntity;
	}
	public ResponseEntity<ResponseStructure<Hospital>> getHospitalById(int id){
		ResponseStructure<Hospital> responseStructure=new ResponseStructure<Hospital>();

		Hospital hospital=dao.getHospitalById(id);
		if(hospital!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("received");
			responseStructure.setData(dao.getHospitalById(id));
		}else {
			throw new NoSuchIdFoundException("No Such Id Found");
			}
		
		ResponseEntity<ResponseStructure<Hospital>> responseEntity=new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.OK);

		return responseEntity;
	}
	public ResponseEntity<ResponseStructure<String>> deleteHospitalById(int id){
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("deleted");
		responseStructure.setData(dao.deleteHospitalById(id));
		
		ResponseEntity<ResponseStructure<String>> responseEntity=new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.OK);

	return responseEntity;
	}


}
