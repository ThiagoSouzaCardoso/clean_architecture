package org.example.adapter.repository.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class UserEntity implements Serializable {
	
	private static final long serialVersionUID = -5437143829650403182L;

	@Id
    @Column(columnDefinition = "BINARY(16)")
	private String id;
	private String email;
	private String password;
	private String lastName;
	private String firstName;

}
