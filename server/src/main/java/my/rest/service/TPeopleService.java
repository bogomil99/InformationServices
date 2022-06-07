package my.rest.service;

import java.util.List;

import my.rest.exception.BackendErrorsException;
import my.rest.model.tables.TPeople;

/**
 * @author bborisov
 */
public interface TPeopleService {

	/**
	* Saving record to a TPeople table. The method 
	* throws BackendErrorsException with detail 
	* message if entity has wrong fullName or pin
	* 
	* @param entity
	* @throws BackendErrorsException
	*/
	public TPeople save(TPeople entity) throws BackendErrorsException;

	/**
	* Deletes record by TPeople table
	* 
	* @param entity
	*/
	public void delete(TPeople entity);

	/**
	* The method returns all TPeople records that contain the parameter: name
	* 
	* @param name
	*/
	public List<TPeople> findTPeopleLikeName(String name);

	/**
	* Returns all records from table TPeople
	* 
	*/
	public List<TPeople> findAll();
	
	/**
	* Returns TPeople record by an id
	* 
	*/
	public TPeople findById(Long id);

	/**
	* The method creates a new record in TPeople table
	* 
	* @param fullName
	* @param pin
	* @return Saved TPeople object
	* @throws BackendErrorsException
	*/
	public TPeople create(String fullName, String pin) throws BackendErrorsException;

	/**
	* The method updates the TPeople record by an id
	* 
	* @param id
	* @param fullName
	* @param pin
	* @throws BackendErrorsException
	*/
	public TPeople update(Long id, String fullName, String pin) throws BackendErrorsException;

}
