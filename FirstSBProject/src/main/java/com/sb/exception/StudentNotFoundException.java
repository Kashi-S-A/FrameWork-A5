package com.sb.exception;

public class StudentNotFoundException extends RuntimeException {

	private String message;

	public StudentNotFoundException() {
	}

	public StudentNotFoundException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
}
