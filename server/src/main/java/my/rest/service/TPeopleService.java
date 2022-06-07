package my.rest.service;

import java.util.List;

import my.rest.exception.BackendErrorsException;
import my.rest.model.tables.TPeople;

public interface TPeopleService {

	public TPeople save(TPeople entity) throws BackendErrorsException;

	public void delete(TPeople entity);

	public List<TPeople> findTPeopleLikeName(String name);

	public List<TPeople> findAll();
	
	public TPeople findById(Long id);

	public TPeople create(String fullName, String pin) throws BackendErrorsException;

	public TPeople update(Long id, String fullName, String pin) throws BackendErrorsException;

}
