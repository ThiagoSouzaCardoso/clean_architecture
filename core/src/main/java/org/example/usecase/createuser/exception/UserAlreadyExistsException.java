package org.example.usecase.createuser.exception;

public class UserAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 8306811971821367381L;

	public UserAlreadyExistsException(final String email) {
		super(email);
	}
}
