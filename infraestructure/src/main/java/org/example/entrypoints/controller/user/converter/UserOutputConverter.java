package org.example.entrypoints.controller.user.converter;

import org.example.entrypoints.controller.user.UserInput;
import org.example.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserOutputConverter implements PresentersConverter<UserInput, User> {

	@Override
	public User mapToEntity(final UserInput rest) {
		return  User.builder()
                .id(rest.getId())
                .email(rest.getEmail())
                .password(rest.getPassword())
                .lastName(rest.getLastName())
                .firstName(rest.getFirstName())
                .build();
	}

	@Override
	public UserInput mapToRest(final User entity) {
		return new UserInput(entity.getId(),entity.getEmail(),entity.getPassword(),entity.getLastName(),entity.getFirstName());
	}

}
