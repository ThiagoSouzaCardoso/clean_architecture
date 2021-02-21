package org.example.adapter.controller;

import java.net.URI;

import org.example.adapter.presenters.user.UserInput;
import org.example.adapter.presenters.user.UserOutput;
import org.example.adapter.presenters.user.converter.PresentersConverter;
import org.example.model.User;
import org.example.usecase.createuser.CreateUser;
import org.example.usecase.findoneuser.FindOneUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

	private final PresentersConverter<UserInput, User> restInputConverter;	
	private final PresentersConverter<UserOutput, User> restOutputConverter;	
	private final CreateUser createUser;
	private final FindOneUser findOneUser;

	@PostMapping
	public ResponseEntity<Void> createUser(@RequestBody UserInput userWeb, UriComponentsBuilder uriBuilder){
		User entity = restInputConverter.mapToEntity(userWeb);
		User user = createUser.execute(entity);
		
		URI uri = uriBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserOutput> buscar(@PathVariable("id") String id) {
		User user = findOneUser.execute(id);
		UserOutput response = restOutputConverter.mapToRest(user);
		return ResponseEntity.ok(response);
	}
	
}
