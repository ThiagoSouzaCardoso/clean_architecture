package org.example.usecase.createuser;

import org.example.model.User;
import org.example.ports.IdGenerator;
import org.example.ports.PasswordEncoder;
import org.example.ports.UserRepository;
import org.example.usecase.createuser.exception.UserAlreadyExistsException;
import org.example.usecase.createuser.validator.UserValidator;

public class CreateUserImpl implements CreateUser {

	private final UserRepository createUserRepository;
	private final PasswordEncoder passwordEncoder;
    private final IdGenerator idGenerator;
	
	public CreateUserImpl(UserRepository createUserRepository, PasswordEncoder passwordEncoder,IdGenerator idGenerator) {
		this.createUserRepository = createUserRepository;
		this.passwordEncoder = passwordEncoder;
		this.idGenerator = idGenerator;
	}

	@Override
	public User execute(User user) throws UserAlreadyExistsException {
		 UserValidator.validateCreateUser(user);
	        if (createUserRepository.doesUserEmailExists(user.getEmail())) {
	            throw new UserAlreadyExistsException(user.getEmail());
	        }
	        var userToSave = User.builder()
	                .id(idGenerator.generate())
	                .email(user.getEmail())
	                .password(passwordEncoder.encode(user.getEmail() + user.getPassword()))
	                .lastName(user.getLastName())
	                .firstName(user.getFirstName())
	                .build();
	       return createUserRepository.create(userToSave);
	}

}
