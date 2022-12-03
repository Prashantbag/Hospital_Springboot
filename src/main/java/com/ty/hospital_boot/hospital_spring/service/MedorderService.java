package com.ty.hospital_boot.hospital_spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.hospital_boot.hospital_spring.dao.MedorderDao;
import com.ty.hospital_boot.hospital_spring.dto.Encounter;
import com.ty.hospital_boot.hospital_spring.dto.Hospital;
import com.ty.hospital_boot.hospital_spring.dto.Medorder;
import com.ty.hospital_boot.hospital_spring.exception.NoSuchIdFoundException;
import com.ty.hospital_boot.hospital_spring.util.ResponseStructure;

@Service
public class MedorderService {
	@Autowired
	private MedorderDao dao;
	
	public ResponseEntity<ResponseStructure<Medorder>> updateMedorderById(Medorder medorder,int id){
		ResponseStructure<Medorder> responseStructure=new ResponseStructure<Medorder>();
		Medorder medorder2=dao.getMedorderById(id);
		if(medorder2!=null) {
			medorder.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("updated");
			responseStructure.setData(dao.updateMedorder(medorder));
		}else {
			throw new NoSuchIdFoundException("No Such Id To Be Updated");
		}
		ResponseEntity<ResponseStructure<Medorder>> responseEntity=new ResponseEntity<ResponseStructure<Medorder>>(responseStructure,HttpStatus.OK);

		return responseEntity;
	}
	public ResponseEntity<ResponseStructure<Medorder>> getMedorderById(int id){
		ResponseStructure<Medorder> responseStructure=new ResponseStructure<Medorder>();
		Medorder medorder2=dao.getMedorderById(id);
		if(medorder2!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("received");
			responseStructure.setData(dao.getMedorderById(id));
		}else {
			throw new NoSuchIdFoundException("No Such Id Found");
		}
		ResponseEntity<ResponseStructure<Medorder>> responseEntity=new ResponseEntity<ResponseStructure<Medorder>>(responseStructure,HttpStatus.OK);

		return responseEntity;
	}
	
	
	
	

}
