package org.example.adapter.idgenerator.jud;

import com.fasterxml.uuid.EthernetAddress;
import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.NoArgGenerator;

import lombok.NoArgsConstructor;

import org.example.ports.IdGenerator;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@NoArgsConstructor
@Component
public class JugIdGenerator  implements IdGenerator {

	@Override
    public String generate() {
        return generator().generate().toString().replaceAll("-", "");
    }

    private static NoArgGenerator generator() {
        return Generators.timeBasedGenerator(EthernetAddress.fromInterface());
    }
	
}
