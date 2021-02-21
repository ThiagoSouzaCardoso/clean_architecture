package org.example.entrypoints.controller.user.converter;

import org.example.entrypoints.controller.user.UserOutput;
import org.example.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserInputConverter implements PresentersConverter<UserOutput, User> {

	@Override
	public User mapToEntity(final UserOutput rest) {
		return null;
	}

	@Override
	public UserOutput mapToRest(final User entity) {
		return new UserOutput(entity.getId(),entity.getEmail(),entity.getLastName(),entity.getFirstName());
	}

}
