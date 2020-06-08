package org.example.configuration;

import org.example.adapter.encode.sha256.Sha256PasswordEncoder;
import org.example.adapter.idgenerator.jud.JugIdGenerator;
import org.example.ports.UserRepository;
import org.example.usecase.createuser.CreateUser;
import org.example.usecase.createuser.CreateUserImpl;
import org.example.usecase.findoneuser.FindOneUser;
import org.example.usecase.findoneuser.FindOneUserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories
public class ApplicationConfiguration {

	@Autowired
	private UserRepository repoUserRepository;

	@Autowired
	private JugIdGenerator jug;
	
	@Autowired
	private Sha256PasswordEncoder sha256PasswordEncoder;
	
	@Bean
	public CreateUser createUser() {
		return new CreateUserImpl(repoUserRepository,sha256PasswordEncoder,jug);
	}

	@Bean
	public FindOneUser findOneUser() {
		return new FindOneUserImpl(repoUserRepository);
	}
	
}
