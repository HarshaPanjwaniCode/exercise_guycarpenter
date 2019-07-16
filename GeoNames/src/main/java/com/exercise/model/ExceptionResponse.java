package com.exercise.model;

import org.springframework.http.HttpStatus;

public class ExceptionResponse {
	private HttpStatus statusCode;
	private String message;

	public ExceptionResponse(HttpStatus statusCode, String message) {
		super();
		this.statusCode = statusCode;
		this.message = message;
	}

	public HttpStatus getStatusCode() {
		return statusCode;
	}

	public String getMessage() {
		return message;
	}

}
