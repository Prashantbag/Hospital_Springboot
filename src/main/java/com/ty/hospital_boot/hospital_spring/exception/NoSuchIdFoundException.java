package com.ty.hospital_boot.hospital_spring.exception;

public class NoSuchIdFoundException extends RuntimeException{

	
	String message = "No Such Id Found";

	@Override
	public String getMessage() {
		return message;
	}

	public NoSuchIdFoundException(String message) {
		super();
		this.message = message;
	}

	public NoSuchIdFoundException() {
		super();
	}
	
	
	
}
