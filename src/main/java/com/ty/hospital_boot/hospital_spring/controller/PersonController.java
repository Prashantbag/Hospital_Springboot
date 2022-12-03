package com.ty.hospital_boot.hospital_spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.hospital_boot.hospital_spring.dto.Branch;
import com.ty.hospital_boot.hospital_spring.dto.Person;
import com.ty.hospital_boot.hospital_spring.service.PersonService;
import com.ty.hospital_boot.hospital_spring.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("person")
public class PersonController {

	@Autowired
	private PersonService personService;

	@ApiOperation(value = "Save Person", notes = "It is used to save the person ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 500, message = "internal ServerError"),
			@ApiResponse(code = 404, message = "notfound") })
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_ATOM_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Person>> savePerson(@RequestBody Person person) {
		return personService.savePerson(person);
	}

	@ApiOperation(value = "Update Person", notes = "It is used to update the person ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 500, message = "internal ServerError"),
			@ApiResponse(code = 404, message = "notfound") })
	@PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_ATOM_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Person>> updatePersonById(@RequestBody Person person, @RequestParam int id) {
		return personService.updatePersonById(person, id);

	}

	@ApiOperation(value = "get person by Id", notes = "It is used to get the personby Id ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 500, message = "internal ServerError"),
			@ApiResponse(code = 404, message = "notfound") })
	@GetMapping(produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Person>> getPersonById(@RequestParam int id) {
		return personService.getPersonById(id);

	}


	@ApiOperation(value = "Delete person by Id", notes = "It is used to delete the personby Id ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 500, message = "internal ServerError"),
			@ApiResponse(code = 404, message = "notfound") })
	@DeleteMapping(value="/{id}",produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<String>> deletePersonById(@PathVariable int id) {
		return personService.deletePersonById(id);

	}

}


