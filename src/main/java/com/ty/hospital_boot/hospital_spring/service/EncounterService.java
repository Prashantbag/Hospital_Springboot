package com.ty.hospital_boot.hospital_spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.hospital_boot.hospital_spring.dao.BranchDao;
import com.ty.hospital_boot.hospital_spring.dao.EncounterDao;
import com.ty.hospital_boot.hospital_spring.dao.PersonDao;
import com.ty.hospital_boot.hospital_spring.dto.Address;
import com.ty.hospital_boot.hospital_spring.dto.Branch;
import com.ty.hospital_boot.hospital_spring.dto.Encounter;
import com.ty.hospital_boot.hospital_spring.dto.Person;
import com.ty.hospital_boot.hospital_spring.exception.NoSuchIdFoundException;
import com.ty.hospital_boot.hospital_spring.util.ResponseStructure;

@Service
public class EncounterService {
	@Autowired
	private EncounterDao dao;

	@Autowired
	private BranchDao branchDao;

	@Autowired
	private PersonDao personDao;

	public ResponseEntity<ResponseStructure<Encounter>> updateEncounterById(Encounter encounter, int id) {
		ResponseStructure<Encounter> responseStructure = new ResponseStructure<Encounter>();
		ResponseEntity<ResponseStructure<Encounter>> responseEntity = new ResponseEntity<ResponseStructure<Encounter>>(
				responseStructure, HttpStatus.OK);
		Encounter encounter2 = dao.getEncounterById(id);
		if (encounter2 != null) {
			encounter.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("updated");
			responseStructure.setData(dao.updateEncounter(encounter, id));
		} else {
			throw new NoSuchIdFoundException("No Such Id To Be Updated");
		}
		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<Encounter>> getEncounterById(int id) {
		ResponseStructure<Encounter> responseStructure = new ResponseStructure<Encounter>();
		ResponseEntity<ResponseStructure<Encounter>> responseEntity = new ResponseEntity<ResponseStructure<Encounter>>(
				responseStructure, HttpStatus.OK);
		Encounter encounter = dao.getEncounterById(id);
		if (encounter != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("received");
			responseStructure.setData(dao.getEncounterById(id));
		} else {
			throw new NoSuchIdFoundException("No Such Id Found");
		}
		return responseEntity;
	}

	
	List<Encounter> elist=new ArrayList<Encounter>();
	public ResponseEntity<ResponseStructure<Person>> saveEncounter(Encounter encounter, int pid, int bid) {
		ResponseStructure<Person> responseStructure = new ResponseStructure<Person>();
		ResponseEntity<ResponseStructure<Person>> responseEntity = new ResponseEntity<ResponseStructure<Person>>(	responseStructure, HttpStatus.OK);
		Person person = personDao.getPersonById(pid);
		if (person != null) {
			List<Branch> list = (List<Branch>) branchDao.getBranchById(bid);
			if (list.size() != 0) {
				encounter.setBranch(list);
				responseStructure.setStatus(HttpStatus.CREATED.value());
				responseStructure.setMessage("saved");
				Encounter encounter2=dao.saveEncounter(encounter);
				elist.add(encounter2);
				person.setEncounter(elist);
				responseStructure.setData(person);
					
			} else {
				throw new NoSuchIdFoundException();
			}
		}return responseEntity;
	}

}
