package org.example.usecase.createuser.exception;

public class UserValidationException extends RuntimeException {

	private static final long serialVersionUID = 3616532258650005652L;

	public UserValidationException(String string) {
		super(string);
	}

}
