package org.example.adapter.controller.mapper;

import static org.springframework.http.HttpStatus.CONFLICT;

import org.example.usecase.createuser.exception.UserAlreadyExistsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class UserAlreadyExistExceptionMapper extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = { UserAlreadyExistsException.class })
	protected ResponseEntity<String> handleUserAlreadyExistsException(RuntimeException ex, WebRequest request) {
		return ResponseEntity.status(CONFLICT).body("User Already Exist");
	}
	
}