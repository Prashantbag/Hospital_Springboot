package com.ty.hospital_boot.hospital_spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.hospital_boot.hospital_spring.dao.BranchDao;
import com.ty.hospital_boot.hospital_spring.dao.EncounterDao;
import com.ty.hospital_boot.hospital_spring.dao.PersonDao;
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
	private PersonDao personDao;
	
	@Autowired
	private BranchDao branchDao;

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

	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(Encounter encounter, int pid,int bid) {
		ResponseStructure<Encounter> responseStructure = new ResponseStructure<Encounter>();
		ResponseEntity<ResponseStructure<Encounter>> responseEntity = new ResponseEntity<ResponseStructure<Encounter>>(
				responseStructure, HttpStatus.CREATED);
		Person person = personDao.getPersonById(pid);
		Branch branch=branchDao.getBranchById(bid);
		List<Branch> branchlist=encounter.getBranch();
		if(branch!=null) {	
			branchlist.add(branch);
		}else {
			throw new NoSuchIdFoundException("No Such Id Found For Branch");
		}
		if (person != null) {
			List<Encounter> list = person.getEncounter();
			list.add(encounter);
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMessage("Saved");
			encounter.setBranch(branchlist);
			responseStructure.setData(dao.saveEncounter(encounter));
			personDao.updatePerson(person, pid);
		} else {
			throw new NoSuchIdFoundException("No Such Id Found for Person");
		}
		return responseEntity;
	}

}
