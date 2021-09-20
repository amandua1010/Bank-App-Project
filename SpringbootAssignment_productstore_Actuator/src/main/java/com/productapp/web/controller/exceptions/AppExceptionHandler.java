package com.productapp.web.controller.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.productapp.web.exceptions.ProductNotFoundException;

@ControllerAdvice
@RestController
public class AppExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Override					// if validation fails then I have to come here
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		ErrorDetails details = new ErrorDetails("Contact: customerCare@gmail.com", "Server side validation failed", request.getDescription(false));
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(details);
		
	}

	// 404 Exception
	@ExceptionHandler(ProductNotFoundException.class) 				// it means ProductNotFoundException aaya to vahan transfer ho jaayega control
	public ResponseEntity<ErrorDetails> handle404Exception(Exception ex, WebRequest request){
		
		ErrorDetails details = new ErrorDetails();
		details.setEmailId("Contact: customerCare@gmail.com");
		details.setMessage("Product/ Resource not found");
		details.setDetailMessage(ex.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(details);
		
	}
	
	// 500 Exception
	@ExceptionHandler(Exception.class) 
	public ResponseEntity<ErrorDetails> handle500Exception(Exception ex, WebRequest request){
		
		ErrorDetails details = new ErrorDetails();
		details.setEmailId("Contact: customerCare@gmail.com");
		details.setMessage("Some server side error");
		details.setDetailMessage(ex.getMessage());
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(details);
		
	}
	
}
