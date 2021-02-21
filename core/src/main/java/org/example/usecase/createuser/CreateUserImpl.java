package org.example.usecase.createuser;

import org.example.model.User;
import org.example.ports.encode.PasswordEncoder;
import org.example.ports.repository.UserRepository;
import org.example.usecase.createuser.exception.UserAlreadyExistsException;
import org.example.usecase.createuser.validator.UserValidator;

public class CreateUserImpl implements CreateUser {

	private final UserRepository createUserRepository;
	private final PasswordEncoder passwordEncoder;

	public CreateUserImpl(UserRepository createUserRepository, PasswordEncoder passwordEncoder) {
		this.createUserRepository = createUserRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public User execute(User user) throws UserAlreadyExistsException {
		 UserValidator.validateCreateUser(user);
	        if (createUserRepository.doesUserEmailExists(user.getEmail())) {
	            throw new UserAlreadyExistsException(user.getEmail());
	        }

	        var userToSave = User.builder()
	                .email(user.getEmail())
	                .password(passwordEncoder.encode(user.getEmail() + user.getPassword()))
	                .lastName(user.getLastName())
	                .firstName(user.getFirstName())
	                .build();
		User userCreated = createUserRepository.create(userToSave);

		return userCreated;

	}

}
