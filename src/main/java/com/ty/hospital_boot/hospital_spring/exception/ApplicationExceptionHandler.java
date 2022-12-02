package com.ty.hospital_boot.hospital_spring.exception;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ty.hospital_boot.hospital_spring.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler{

	
	@ExceptionHandler(NoSuchIdFoundException.class)
	public ResponseEntity<ResponseStructure<String>> noSuchIdFoundExceptionHandler(NoSuchIdFoundException exception){
		
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("NO SUCH ID FOUND");
		responseStructure.setData(exception.getMessage());
		
		ResponseEntity<ResponseStructure<String>> responseEntity = new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
		
		return responseEntity;
		
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		List<ObjectError> error= ex.getAllErrors();
		
		Map<String,String> map =  new LinkedHashMap<String, String>();
		
		for (ObjectError objectError : error) {
			
			String message = objectError.getDefaultMessage();
			String fieldname=((FieldError)objectError).getField();
			map.put(message, fieldname);
		}
		
		ResponseStructure<Map<String, String>> responseStructure = new ResponseStructure<Map<String,String>>();
		responseStructure.setStatus(HttpStatus.BAD_GATEWAY.value());
		responseStructure.setMessage("Invalid Input Found");
		responseStructure.setData(map);
		
		return new ResponseEntity<>(responseStructure,HttpStatus.BAD_GATEWAY);
	}
	
	
	 
	
	
	
}
