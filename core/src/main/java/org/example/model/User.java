package org.example.model;

import java.io.Serializable;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class User implements Serializable{
	private static final long serialVersionUID = -2301508179010452490L;

	private String id;
	private String email;
	private String password;
	private String lastName;
	private String firstName;

}
