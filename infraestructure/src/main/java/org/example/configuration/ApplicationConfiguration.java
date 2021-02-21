package org.example.configuration;

import org.example.adapters.encoders.sha256.Sha256PasswordEncoder;
import org.example.dataproviders.databases.UserRepositoryImpl;
import org.example.dataproviders.databases.convert.UserRepositoryConverter;
import org.example.ports.repository.UserRepository;
import org.example.usecase.createuser.CreateUser;
import org.example.usecase.createuser.CreateUserImpl;
import org.example.usecase.findoneuser.FindOneUser;
import org.example.usecase.findoneuser.FindOneUserImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.EntityManager;

@Configuration
@EnableJpaRepositories
public class ApplicationConfiguration {

	@Bean
	public UserRepository userRepository(EntityManager entityManager, UserRepositoryConverter userRepositoryConverter){
		return new UserRepositoryImpl(entityManager,userRepositoryConverter);
	}

	@Bean
	public UserRepositoryConverter userRepositoryConverter(){
		return new UserRepositoryConverter();
	}

	@Bean
	public Sha256PasswordEncoder sha256PasswordEncoder(){
		return new Sha256PasswordEncoder();
	}

	@Bean
	public CreateUser createUser(Sha256PasswordEncoder sha256PasswordEncoder, UserRepository userRepository) {
		return new CreateUserImpl(userRepository,sha256PasswordEncoder);
	}

	@Bean
	public FindOneUser findOneUser(UserRepository userRepository) {
		return new FindOneUserImpl(userRepository);
	}
	
}
