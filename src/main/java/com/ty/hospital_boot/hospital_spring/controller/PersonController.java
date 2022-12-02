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
import com.ty.hospital_boot.hospital_spring.service.AddressService;
import com.ty.hospital_boot.hospital_spring.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("Address")
public class PersonController {

	@Autowired
	private AddressService addressService;

	@ApiOperation(value = "Save Addresses", notes = "It is used to save the person Address")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 500, message = "internal ServerError"),
			@ApiResponse(code = 404, message = "notfound") })
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_ATOM_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@RequestBody Address address) {
		return addressService.saveAddress(address);
	}

	@PutMapping
	public ResponseEntity<ResponseStructure<Address>> updateAddress(@RequestBody Address address,
			@RequestParam int id) {
		return addressService.updateAddress(address, id);

	}

	@GetMapping
	public ResponseEntity<ResponseStructure<Address>> getAddress(@RequestParam int id) {
		return addressService.getAddress(id);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteAddress(@RequestParam int id) {
		return addressService.deleteAddress(id);

	}
}
