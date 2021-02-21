package org.example.dataproviders.databases;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import lombok.extern.slf4j.Slf4j;
import org.example.dataproviders.databases.convert.RepositoryConverter;
import org.example.dataproviders.databases.entity.UserEntity;
import org.example.model.User;
import org.example.ports.repository.UserRepository;

@Slf4j
public class UserRepositoryImpl implements UserRepository {

	private final EntityManager entityManager;
	private final RepositoryConverter<User,UserEntity> converter;

	public UserRepositoryImpl(EntityManager entityManager, RepositoryConverter<User,UserEntity> converter) {
		this.entityManager = entityManager;
		this.converter = converter;
	}

	@Override
	@Transactional(Transactional.TxType.REQUIRED)
	public User create(User user) {
		log.info("create Entity Manager is open? {}",entityManager.isJoinedToTransaction());

		UserEntity entity =  converter.mapToTable(user);
		entityManager.persist(entity);
		return converter.mapToEntity(entity);
	}
	
	@Override
	@Transactional(Transactional.TxType.NOT_SUPPORTED)
	public Boolean doesUserEmailExists(String email) {
		String sql= "select (count(email) > 0) from UserEntity where email = :pMail";
		TypedQuery<Boolean> query = entityManager.createQuery(sql, Boolean.class);
		query.setParameter("pMail", email);
		return query.getSingleResult();
	}
	
	@Override
	@Transactional(Transactional.TxType.NOT_SUPPORTED)
	public List<User> findAllUsersPaginated(int pageNo, int pageSize) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

		CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
		Root<User> from = criteriaQuery.from(User.class);
		CriteriaQuery<User> select = criteriaQuery.select(from);

		TypedQuery<User> query = entityManager.createQuery(select);
		query.setFirstResult(pageNo);
		query.setMaxResults(pageSize);

		return query.getResultList();
	}
	
	@Override
	@Transactional(Transactional.TxType.NOT_SUPPORTED)
	public Optional<User> findById(String id) {
			Optional<UserEntity> userEntity = Optional.ofNullable(entityManager.find(UserEntity.class, UUID.fromString(id)));
			return userEntity.map(converter::mapToEntity);	
	}

}
