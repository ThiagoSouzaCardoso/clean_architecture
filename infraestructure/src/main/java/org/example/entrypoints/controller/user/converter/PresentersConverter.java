package org.example.entrypoints.controller.user.converter;

public interface PresentersConverter<PRESENTERS, ENTITY> {

	default ENTITY mapToEntity(final PRESENTERS rest) {
		throw new UnsupportedOperationException();
	}

	default PRESENTERS mapToRest(final ENTITY entity) {
		throw new UnsupportedOperationException();
	}
}
