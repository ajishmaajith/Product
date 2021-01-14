package com.company.EmployeeManagement.Exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.company.EmployeeManagement.model.ErrorDetails;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
@ExceptionHandler(ResourceNotFoundException.class)

public ResponseEntity<?> resourceNotfoundException(ResourceNotFoundException e, WebRequest request){
	
	ErrorDetails details=new ErrorDetails(new Date(), e.getMessage(), request.getDescription(false));
	return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
	
}

@ExceptionHandler(Exception.class)
public ResponseEntity<?> globalException(Exception e,WebRequest request){
	
	ErrorDetails details=new ErrorDetails(new Date(), e.getMessage(), request.getDescription(false));
	return new ResponseEntity<>(details, HttpStatus.INTERNAL_SERVER_ERROR);
	
}
@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
	ErrorDetails error=new ErrorDetails(new Date(),"Validation failed!", ex.getBindingResult().toString());
		return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
	}


}
