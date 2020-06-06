package org.example.adapter.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.example.adapter.repository.convert.RepositoryConverter;
import org.example.adapter.repository.entity.UserEntity;
import org.example.model.User;
import org.example.ports.UserRepository;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryImpl implements UserRepository,Repository<UserEntity, String> {

	private final EntityManager entityManager;
	private final RepositoryConverter<User,UserEntity> converter;

	public UserRepositoryImpl(EntityManager entityManager, RepositoryConverter<User,UserEntity> converter) {
		this.entityManager = entityManager;
		this.converter = converter;
	}

	@Override
	@Transactional
	public User create(User user) {
		UserEntity entity =  converter.mapToTable(user);
		entityManager.persist(entity);
		return converter.mapToEntity(entity);
	}
	
	@Override
	public Boolean doesUserEmailExists(String email) {
		String sql= "select count(email)>0 from UserEntity where email = :pMail";
		TypedQuery<Boolean> query = entityManager.createQuery(sql, Boolean.class);
		query.setParameter("pMail", email);
		return query.getSingleResult();
	}
	
	@Override
	public List<User> findAllUsers() {
		
		return null;
	}
	
	@Override
	public Optional<User> findById(String id) {
			Optional<UserEntity> userEntity = Optional.ofNullable(entityManager.find(UserEntity.class, id));
			return userEntity.map(converter::mapToEntity);	
	}

}
