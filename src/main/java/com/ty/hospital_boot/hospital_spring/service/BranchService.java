package com.ty.hospital_boot.hospital_spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.hospital_boot.hospital_spring.dao.BranchDao;
import com.ty.hospital_boot.hospital_spring.dto.Branch;
import com.ty.hospital_boot.hospital_spring.util.ResponseStructure;

@Service
public class BranchService {
	@Autowired
private BranchDao dao;
	
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch branch){
		ResponseStructure<Branch> responseStructure=new ResponseStructure<Branch>();
		ResponseEntity<ResponseStructure<Branch>> responseEntity=new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Saved");
		responseStructure.setData(dao.saveBranch(branch));
		return responseEntity;
	}
	public ResponseEntity<ResponseStructure<Branch>> updateBranchById(Branch branch,int id){
		ResponseStructure<Branch> responseStructure=new ResponseStructure<Branch>();
		ResponseEntity<ResponseStructure<Branch>> responseEntity=new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
		Branch branch2=dao.getBranchById(id);
		if(branch2!=null) {
			branch.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Updated");
			responseStructure.setData(dao.updateBranchById());
		}else {
			throw new NoSuchIdUpdate("No Such Id To Be Updated");
		}
		return responseEntity;
	}
	public ResponseEntity<ResponseStructure<Branch>> getBranchById(int id){
		ResponseStructure<Branch> responseStructure=new ResponseStructure<Branch>();
		ResponseEntity<ResponseStructure<Branch>> responseEntity=new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
	}

}
