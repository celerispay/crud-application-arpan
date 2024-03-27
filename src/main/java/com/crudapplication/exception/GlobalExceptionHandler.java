package com.crudapplication.exception;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler{

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ResponseEntity<Object> handleGenericException(Exception ex) {
		return new ResponseEntity<>("An unexpected error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
		
		String errorMessage="Validation Failed";
		FieldError fieldError=ex.getBindingResult().getFieldError();
		if(fieldError!=null) {
			errorMessage =fieldError.getDefaultMessage();
		}
		
		return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Validation failed: " + ex.getMessage());
	}
	
	
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<Object> handleMethodNotAllowed(HttpRequestMethodNotSupportedException ex){
		
		return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body("Method Not Allowed:" + ex.getMessage());
	}

}

