package com.cg.fms.exception;

public class InvalidCredentialsException extends RuntimeException{
	String message;
	public InvalidCredentialsException(String message) {
		this.message=message;
	}
	@Override
	public String getMessage() {
		return message;
	}
}
