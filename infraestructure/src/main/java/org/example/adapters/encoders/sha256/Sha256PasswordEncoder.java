package org.example.adapters.encoders.sha256;

import org.apache.commons.codec.digest.DigestUtils;
import org.example.ports.encode.PasswordEncoder;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Sha256PasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(final String str) {
		return DigestUtils.sha256Hex(str);
	}
}
