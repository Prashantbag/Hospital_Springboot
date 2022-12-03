package com.ty.hospital_boot.hospital_spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.hospital_boot.hospital_spring.dto.Encounter;
import com.ty.hospital_boot.hospital_spring.dto.Hospital;
import com.ty.hospital_boot.hospital_spring.service.EncounterService;
import com.ty.hospital_boot.hospital_spring.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("encounter")
public class EncounterController {

	@Autowired
	private EncounterService encounterService;



	@ApiOperation(value = "Update Encounter", notes = "It is used to update the Encounter")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Not found") })
	@PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_ATOM_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Encounter>> updateEncounterById(@RequestBody Encounter encounter,
			@RequestParam int id) {
		return encounterService.updateEncounterById(encounter, id);

	}

	@ApiOperation(value = "Get Encounter by Id ", notes = "It is used to get the Encounter by Id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Not found") })
	@GetMapping( produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Encounter>> getEncounterById(@RequestParam int id) {
		return encounterService.getEncounterById(id);

	}


}
