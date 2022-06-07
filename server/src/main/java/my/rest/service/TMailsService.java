package my.rest.service;

import my.rest.exception.BackendErrorsException;
import my.rest.model.tables.TMails;

public interface TMailsService {

	public TMails save(TMails entity) throws BackendErrorsException;

	public void delete(TMails entity);

	public TMails create(Long tpeopleId, String emailType, String email) throws BackendErrorsException;

	public TMails findById(Long id);
	
	public TMails update(Long id, Long tpeopleId, String emailType, String email) throws BackendErrorsException;

}
