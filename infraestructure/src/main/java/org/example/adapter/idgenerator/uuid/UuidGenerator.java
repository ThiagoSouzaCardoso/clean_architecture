package org.example.adapter.idgenerator.uuid;

import java.util.UUID;

import org.example.ports.IdGenerator;
import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
public class UuidGenerator implements IdGenerator {

	@Override
	public String generate() {
		 return UUID.randomUUID().toString();
	}

}
