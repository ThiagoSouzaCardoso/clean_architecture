package org.example.entrypoints.controller.user;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserInput implements Serializable {

	private static final long serialVersionUID = 8677511859422718960L;

	private String id;
	private String email;
	private String password;
	private String lastName;
	private String firstName;

}
