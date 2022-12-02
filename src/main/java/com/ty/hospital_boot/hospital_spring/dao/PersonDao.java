package com.ty.hospital_boot.hospital_spring.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hospital_boot.hospital_spring.dto.Person;
import com.ty.hospital_boot.hospital_spring.repository.PersonRepository;

@Repository
public class PersonDao {

	@Autowired
	private PersonRepository personRepository;
	
	
	public Person savePerson(Person person) {
		return personRepository.save(person);
	}
	
	public Person getPersonById(int id) {
	  Optional< Person> optional=  personRepository.findById(id);
	  if(optional.isPresent()) {
		  return optional.get();
	  }else {
		  return null;
	  }
	}
	
	public Person updatePerson(Person person,int id) {
		Optional< Person> optional=personRepository.findById(id);
		Person person2;
		if(optional.isPresent()) {
			person2=optional.get();
		}else {
			person2=null;
		}
		if(person2!=null) {
			person.setId(id);
			personRepository.save(person);
		    return person;	
		}else {
			return null;
		}
	}
	
	public String deletePersonById(int id) {
		personRepository.deleteById(id);
		return "Deleted";
	}
	
}
