package com.example.econnect.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	

	@ExceptionHandler(ConnectionRequestException.class)
	public ResponseEntity<ErrorResponseDTO> connectionRequestExceptionHandler(ConnectionRequestException ex, WebRequest request) {

		ErrorResponseDTO responseDto = new ErrorResponseDTO();
		responseDto.setMessage(ex.getMessage());
		responseDto.setStatusCode(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);

	}
	

}