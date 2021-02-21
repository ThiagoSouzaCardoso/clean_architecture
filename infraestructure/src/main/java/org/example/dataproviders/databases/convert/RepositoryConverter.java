package org.example.dataproviders.databases.convert;

public interface RepositoryConverter<DOMAIN, TABLE> {

	default TABLE mapToTable(final DOMAIN persistenceObject) {
		throw new UnsupportedOperationException();
	}

	default DOMAIN mapToEntity(final TABLE tableObject) {
		throw new UnsupportedOperationException();
	}

}
