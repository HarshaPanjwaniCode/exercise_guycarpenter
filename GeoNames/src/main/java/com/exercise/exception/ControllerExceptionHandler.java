package com.exercise.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.exercise.model.ExceptionResponse;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = StateNotFoundException.class)
	public ResponseEntity<ExceptionResponse> stateNotFoundException(StateNotFoundException e) {
		return new ResponseEntity<>(new ExceptionResponse(HttpStatus.NOT_FOUND, e.getMessage()), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = ZipNotFoundException.class)
	public ResponseEntity<ExceptionResponse> zipNotFoundException(ZipNotFoundException e) {
		return new ResponseEntity<>(new ExceptionResponse(HttpStatus.NOT_FOUND, e.getMessage()), HttpStatus.NOT_FOUND);
	}
}
