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

import com.ty.hospital_boot.hospital_spring.dto.Address;
import com.ty.hospital_boot.hospital_spring.dto.Medorder;
import com.ty.hospital_boot.hospital_spring.service.MedorderService;
import com.ty.hospital_boot.hospital_spring.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("Medorder")
public class MedorderController {

	@Autowired
	 private MedorderService medorderService ;
	
	
	@ApiOperation(value = "Save Addresses", notes = "It is used to save the person Address")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 500, message = "internal ServerError"),
			@ApiResponse(code = 404, message = "notfound") })
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_ATOM_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Medorder>> saveMedorder(@RequestBody Medorder medorder
			) {
		return medorderService .saveMedorder(medorder);
	}

	@PutMapping
	public ResponseEntity<ResponseStructure<Medorder>> updateMedorder(@RequestBody Medorder medorder,
			@RequestParam int id) {
		return  medorderService.updateMedorder( medorder, id);

	}

	@GetMapping
	public ResponseEntity<ResponseStructure<Medorder>> getMedorder(@RequestParam int id) {
		return medorderService.getMedorder(id);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteMedorder(@RequestParam int id) {
		return medorderService.deleteMedorder(id);

	}
	
	
	
	
	
	
	
	
	
	
	
	
}
