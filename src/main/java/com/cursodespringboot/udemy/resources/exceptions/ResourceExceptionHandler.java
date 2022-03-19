package com.cursodespringboot.udemy.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cursodespringboot.udemy.services.exceptions.DataIntegrityException;
import com.cursodespringboot.udemy.services.exceptions.ObjectNoFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNoFoundException.class)
	public ResponseEntity<StandartError> objectNotFound(ObjectNoFoundException e, HttpServletRequest request){
		 StandartError err = new StandartError(HttpStatus.NOT_FOUND.value(), e.getMessage(),System.currentTimeMillis());
		 return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	
	@ExceptionHandler(DataIntegrityException.class)
	public ResponseEntity<StandartError> dataIntegrityException(DataIntegrityException e, HttpServletRequest request){
		 StandartError err = new StandartError(HttpStatus.BAD_REQUEST.value(), e.getMessage(),System.currentTimeMillis());
		 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
	

}
