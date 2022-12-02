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

import com.ty.hospital_boot.hospital_spring.dto.Items;
import com.ty.hospital_boot.hospital_spring.dto.Medorder;
import com.ty.hospital_boot.hospital_spring.service.ItemsService;
import com.ty.hospital_boot.hospital_spring.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("Items")
public class ItemsController {
	@Autowired
	private ItemsService itemsService;

	@ApiOperation(value = "Save Items", notes = "It is used to save the Items ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 500, message = "internal ServerError"),
			@ApiResponse(code = 404, message = "notfound") })
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_ATOM_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Items>> saveItems(@RequestBody Items items) {
		return itemsService.saveItems(items);
	}

	@ApiOperation(value = "update Items", notes = "It is used to Update The Items")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 500, message = "internal ServerError"),
			@ApiResponse(code = 404, message = "notfound") })
	@PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_ATOM_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Items>> updateItems(@RequestBody Items items, @RequestParam int id) {
		return itemsService.updateItems(items, id);

	}

	@ApiOperation(value = "Get Items by Id", notes = "It is used to get the Items by Id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 500, message = "internal ServerError"),
			@ApiResponse(code = 404, message = "notfound") })
	@GetMapping(produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Items>> getItemsById(@RequestParam int id) {
		return itemsService.getItems(id);

	}

	@ApiOperation(value = "Delete Items by Id", notes = "It is used to delete the Items by Id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 500, message = "internal ServerError"),
			@ApiResponse(code = 404, message = "notfound") })
	@DeleteMapping(value="/{id}",produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<String>> deleteItemsById(@RequestParam int id) {
		return itemsService.deleteitems(id);

	}

}
