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

import com.ty.hospital_boot.hospital_spring.dto.Hospital;
import com.ty.hospital_boot.hospital_spring.dto.Items;
import com.ty.hospital_boot.hospital_spring.service.HospitalService;
import com.ty.hospital_boot.hospital_spring.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("Hospital")
public class HospitalController {

@Autowired
private	HospitalService hospitalService;
	
@ApiOperation(value = "Save Hospital", notes = "It is used to save the Hospital")
@ApiResponses(value = { @ApiResponse(code = 201, message = "created"),
		@ApiResponse(code = 500, message = "internal ServerError"),
		@ApiResponse(code = 404, message = "notfound") })
@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_ATOM_XML_VALUE }, produces = {
		MediaType.APPLICATION_JSON_VALUE })
public ResponseEntity<ResponseStructure<Hospital>> saveHospital(@RequestBody Hospital hospital) {
	return hospitalService.savehospital(hospital);
}

@ApiOperation(value = "Update Hospital", notes = "It is used to update the hospital")
@ApiResponses(value = { @ApiResponse(code = 201, message = "created"),
		@ApiResponse(code = 500, message = "internal ServerError"),
		@ApiResponse(code = 404, message = "notfound") })
@PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_ATOM_XML_VALUE }, produces = {
		MediaType.APPLICATION_JSON_VALUE })
public ResponseEntity<ResponseStructure<Hospital>> updatehospital(@RequestBody Hospital hospital,
		@RequestParam int id) {
	return hospitalService.updatehospital(hospital, id);

}

@ApiOperation(value = "Get hospital by Id", notes = "It is used to get the hospital by Id")
@ApiResponses(value = { @ApiResponse(code = 201, message = "created"),
		@ApiResponse(code = 500, message = "internal ServerError"),
		@ApiResponse(code = 404, message = "notfound") })
@GetMapping(produces = {
		MediaType.APPLICATION_JSON_VALUE })
public ResponseEntity<ResponseStructure<Hospital>> getHospitalById(@RequestParam int id) {
	return hospitalService.gethospital(id);

}

@ApiOperation(value = "Delete hospital by Id", notes = "It is used to delete the hospital by Id")
@ApiResponses(value = { @ApiResponse(code = 201, message = "created"),
		@ApiResponse(code = 500, message = "internal ServerError"),
		@ApiResponse(code = 404, message = "notfound") })
@DeleteMapping(value="/{id}",produces = {
		MediaType.APPLICATION_JSON_VALUE })
public ResponseEntity<ResponseStructure<String>> deletehospitalById(@RequestParam int id) {
	return hospitalService.deletehospital(id);

}
}
