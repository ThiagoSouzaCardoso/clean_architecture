package org.example.usecase.findoneuser;

import org.example.model.User;
import org.example.ports.UserRepository;
import org.example.usecase.findoneuser.exception.UserNotFoundException;

public final class FindOneUserImpl implements FindOneUser {

    private final UserRepository repository;

    public FindOneUserImpl(final UserRepository repository) {
        this.repository = repository;
    }
    
     @Override
    public User execute(String id) throws UserNotFoundException {
    	 return repository.findById(id).orElseThrow(UserNotFoundException::new);
    }

}
