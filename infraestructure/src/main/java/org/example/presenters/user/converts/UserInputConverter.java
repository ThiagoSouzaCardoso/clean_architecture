package org.example.presenters.user.converts;

import org.example.model.User;
import org.example.presenters.user.UserOutput;
import org.springframework.stereotype.Component;

@Component
public class UserInputConverter implements PresentersConverter<UserOutput, User> {

	@Override
	public User mapToEntity(final UserOutput rest) {
		throw new UnsupportedOperationException();
	}

	@Override
	public UserOutput mapToRest(final User entity) {
		return new UserOutput(entity.getId(),entity.getEmail(),entity.getLastName(),entity.getFirstName());
	}

}
