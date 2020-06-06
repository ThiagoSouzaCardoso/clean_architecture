package org.example.usecase.findoneuser;

import org.example.model.User;
import org.example.usecase.findoneuser.exception.UserNotFoundException;

public interface FindOneUser {

	User execute(String id) throws UserNotFoundException ;
}
