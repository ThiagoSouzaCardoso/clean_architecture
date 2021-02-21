package org.example.ports;

import java.util.List;
import java.util.Optional;

import org.example.model.User;

public interface FindUserRepository {

	Boolean doesUserEmailExists(String email);
	
	Optional<User> findById(String id);
	
	List<User> findAllUsers();
	
}
