package org.example.entrypoints.controller.handlers;

import org.example.usecase.findoneuser.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class UserNotFoundExceptionMapper extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = { UserNotFoundException.class })
	protected ResponseEntity<String> handleUserAlreadyExistsException(RuntimeException ex, WebRequest request) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
	}
	
}