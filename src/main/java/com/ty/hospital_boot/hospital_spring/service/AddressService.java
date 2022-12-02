package com.ty.hospital_boot.hospital_spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.hospital_boot.hospital_spring.dao.AddressDao;
import com.ty.hospital_boot.hospital_spring.dto.Address;
import com.ty.hospital_boot.hospital_spring.util.ResponseStructure;

@Service
public class AddressService {
	@Autowired
	private AddressDao dao;
	
	
	public ResponseEntity<ResponseStructure<Address>> updateAddressById(Address address,int id){
		ResponseStructure<Address> responseStructure=new ResponseStructure<Address>();
		ResponseEntity<ResponseStructure<Address>> responseEntity=new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.OK);
		Address address2=dao.getAddressById(id);
		if(address2!=null) {
			address.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("updated");
			responseStructure.setData(dao.saveAddress(address));
		}else {
			throw new NoSuchIdUpdate("No Such Id To Be Updated");
		}
		return responseEntity;
	}
	public ResponseEntity<ResponseStructure<Address>> getAddressById(int id){
		ResponseStructure<Address> responseStructure=new ResponseStructure<Address>();
		ResponseEntity<ResponseStructure<Address>> responseEntity=new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.OK);
		Address address=dao.getAddressById(id);
		if(address!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("received");
			responseStructure.setData(dao.getAddressById(id));
		}else {
			throw new NoSuchIdFoundException("No Such Id Found");
		}
		return responseEntity;
	}
	
	
	

}
