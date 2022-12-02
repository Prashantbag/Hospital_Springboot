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

import com.ty.hospital_boot.hospital_spring.dto.Branch;
import com.ty.hospital_boot.hospital_spring.dto.Encounter;
import com.ty.hospital_boot.hospital_spring.service.BranchService;
import com.ty.hospital_boot.hospital_spring.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping
public class BranchController {

@Autowired
private	BranchService branchService;
	
@ApiOperation(value = "Save Branch", notes = "It is used to save the Branch")
@ApiResponses(value = { @ApiResponse(code = 201, message = "created"),
		@ApiResponse(code = 500, message = "Internal Server Error"),
		@ApiResponse(code = 404, message = "Not Found") })
@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_ATOM_XML_VALUE }, produces = {
		MediaType.APPLICATION_JSON_VALUE })
public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestBody Branch branch) {
	return branchService.saveBranch(branch);
}

@ApiOperation(value = "Update Branch", notes = "It is used to Update the branch")
@ApiResponses(value = { @ApiResponse(code = 201, message = "created"),
		@ApiResponse(code = 500, message = "Internal Server Error"),
		@ApiResponse(code = 404, message = "Not Found") })
@PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_ATOM_XML_VALUE }, produces = {
		MediaType.APPLICATION_JSON_VALUE })
public ResponseEntity<ResponseStructure<Branch>> updateBranch(@RequestBody Branch branch, @RequestParam int id) {
	return branchService.updateBranch(branch, id);

}

@ApiOperation(value = "Get Branch by Id", notes = "It is used to get the brqnch by id")
@ApiResponses(value = { @ApiResponse(code = 201, message = "created"),
		@ApiResponse(code = 500, message = "internal ServerError"),
		@ApiResponse(code = 404, message = "notfound") })
@GetMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_ATOM_XML_VALUE }, produces = {
		MediaType.APPLICATION_JSON_VALUE })
public ResponseEntity<ResponseStructure<Branch>> getBranchById(@RequestParam int id) {
	return branchService.getBranch(id);

}
@ApiOperation(value = "Delete Branch by Id", notes = "It is used to delete the brqnch by id")
@ApiResponses(value = { @ApiResponse(code = 201, message = "created"),
		@ApiResponse(code = 500, message = "internal ServerError"),
		@ApiResponse(code = 404, message = "notfound") })
@DeleteMapping(value="/{id}",produces = {
		MediaType.APPLICATION_JSON_VALUE })
public ResponseEntity<ResponseStructure<String>> deleteBranchById(@RequestParam int id) {
	return branchService.deleteBranch(id);

}
}
	
	
	
	
	
	
	
	

