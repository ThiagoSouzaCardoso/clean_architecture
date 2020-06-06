package org.example.usecase.createuser.validator;

import static org.apache.commons.lang3.StringUtils.isBlank;

import org.example.model.User;
import org.example.usecase.createuser.exception.UserValidationException;

public class UserValidator {

	public static void validateCreateUser(final User user) {
        if (user == null) throw new UserValidationException("User should not be null");
        if (isBlank(user.getEmail())) throw new UserValidationException("Email should not be null");
        if (isBlank(user.getFirstName())) throw new UserValidationException("First name should not be null");
        if (isBlank(user.getLastName())) throw new UserValidationException("Last name should not be null");
    }
	
}
