package org.example.usecase.createuser;

import org.example.model.User;
import org.example.usecase.createuser.exception.UserAlreadyExistsException;

public interface CreateUser{
	
	User execute(User user) throws UserAlreadyExistsException ;
}
