package org.example.dataproviders.databases.convert;

import org.example.dataproviders.databases.entity.UserEntity;
import org.example.model.User;

import java.util.Optional;
import java.util.UUID;

public class UserRepositoryConverter implements RepositoryConverter<User, UserEntity> {

	@Override
	public UserEntity mapToTable(final User user) {
		return UserEntity.builder()
				.id(Optional.ofNullable(user.getId()).map(id -> UUID.fromString(id)).orElse(null))
                .email(user.getEmail())
                .password(user.getPassword())
                .lastName(user.getLastName())
                .firstName(user.getFirstName())
                .build();
	}
	
	@Override
	public User mapToEntity(final UserEntity userEntity) {
		return  User.builder()
	                .id(userEntity.getId().toString())
	                .email(userEntity.getEmail())
	                .password(userEntity.getPassword())
	                .lastName(userEntity.getLastName())
	                .firstName(userEntity.getFirstName())
	                .build();
	}
	
}
