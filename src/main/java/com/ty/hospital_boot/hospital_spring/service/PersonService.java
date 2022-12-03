package com.ty.hospital_boot.hospital_spring.service;

import javax.management.loading.PrivateClassLoader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.hospital_boot.hospital_spring.dao.PersonDao;
import com.ty.hospital_boot.hospital_spring.dto.Person;
import com.ty.hospital_boot.hospital_spring.exception.NoSuchIdFoundException;
import com.ty.hospital_boot.hospital_spring.util.ResponseStructure;

@Service
public class PersonService {
@Autowired
private PersonDao dao;

public ResponseEntity<ResponseStructure<Person>> savePerson(Person person){
	ResponseStructure<Person> responseStructure=new ResponseStructure<Person>();
	ResponseEntity<ResponseStructure<Person>> responseEntity=new ResponseEntity<ResponseStructure<Person>>(responseStructure,HttpStatus.OK);
	responseStructure.setStatus(HttpStatus.CREATED.value());
	responseStructure.setMessage("Saved");
	responseStructure.setData(dao.savePerson(person));
	return responseEntity;
	}
	
	public ResponseEntity<ResponseStructure<Person>>  updatePersonById(Person person,int id){
		ResponseStructure<Person> responseStructure=new ResponseStructure<Person>();
		ResponseEntity<ResponseStructure<Person>> responseEntity=new ResponseEntity<ResponseStructure<Person>>(responseStructure,HttpStatus.OK);
		Person person2=dao.getPersonById(id);
		if(person2!=null) {
			person.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Updated");
			responseStructure.setData(person);
		}else {
			throw new   NoSuchIdFoundException("No Such Id To Be Updated");
		}
		return responseEntity;
	}
	public ResponseEntity<ResponseStructure<Person>> getPersonById(int id){
		ResponseStructure<Person> responseStructure=new ResponseStructure<Person>();
		ResponseEntity<ResponseStructure<Person>> responseEntity=new ResponseEntity<ResponseStructure<Person>>(responseStructure,HttpStatus.OK);
		Person person=dao.getPersonById(id);
		if(person!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("received");
			responseStructure.setData(dao.getPersonById(id));
		}else {
			throw new NoSuchIdFoundException("No Such Id Found");
		}
		return responseEntity;
	}
	public ResponseEntity<ResponseStructure<String>> deletePersonById(int id){
	ResponseStructure<String> responseStructure=new ResponseStructure<String>();

	responseStructure.setStatus(HttpStatus.OK.value());
	responseStructure.setMessage("deleted");
	responseStructure.setData(dao.deletePersonById(id));
	ResponseEntity<ResponseStructure<String>> responseEntity=new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.OK);

	return responseEntity;
	
	}

 }
