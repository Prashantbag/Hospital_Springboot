package com.ty.hospital_boot.hospital_spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.hospital_boot.hospital_spring.dao.ItemsDao;
import com.ty.hospital_boot.hospital_spring.dto.Encounter;
import com.ty.hospital_boot.hospital_spring.dto.Items;
import com.ty.hospital_boot.hospital_spring.dto.Medorder;
import com.ty.hospital_boot.hospital_spring.exception.NoSuchIdFoundException;
import com.ty.hospital_boot.hospital_spring.util.ResponseStructure;

@Service
public class ItemsService {
	@Autowired
	private ItemsDao dao;
	
	public ResponseEntity<ResponseStructure<Items>> updateItemsById(Items items,int id){
		ResponseStructure<Items> responseStructure=new ResponseStructure<Items>();
		ResponseEntity<ResponseStructure<Items>> responseEntity=new ResponseEntity<ResponseStructure<Items>>(responseStructure,HttpStatus.OK);
		Items items2=dao.getItemsById(id);
		if(items2!=null) {
			items.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("updated");
			responseStructure.setData(dao.updateItems(items,id));
		}else {
			throw new NoSuchIdFoundException("No Such Id To Be Updated");
		}
		return responseEntity;
	}
	public ResponseEntity<ResponseStructure<Items>> getItemsById(int id){
		ResponseStructure<Items> responseStructure=new ResponseStructure<Items>();
		ResponseEntity<ResponseStructure<Items>> responseEntity=new ResponseEntity<ResponseStructure<Items>>(responseStructure,HttpStatus.OK);
		Items items=dao.getItemsById(id);
		if(items!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("received");
			responseStructure.setData(dao.getItemsById(id));
		}else {
			throw new NoSuchIdFoundException("No Such Id Found");
		}
		return responseEntity;
	}

}
