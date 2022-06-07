package my.rest.service;

import my.rest.exception.BackendErrorsException;
import my.rest.model.tables.TMails;

/**
 * @author bborisov
 */
public interface TMailsService {

	/**
	* Saving record to a TMails table. The method 
	* throws BackendErrorsException with detail 
	* message if entity has wrong email
	* 
	* @param entity
	* @throws BackendErrorsException
	*/
	public TMails save(TMails entity) throws BackendErrorsException;

	/**
	* Deletes record by TMails table
	* 
	* @param entity
	*/
	public void delete(TMails entity);

	/**
	* The method creates a new record in TMails table. 
	* The method throws BackendErrorsException with detail message  
	* if tpeopleId or emailType is null
	* 
	* @param tpeopleId
	* @param emailType
	* @param email
	* @throws BackendErrorsException
	*/
	public TMails create(Long tpeopleId, String emailType, String email) throws BackendErrorsException;

	/**
	* Returns TMails record by an id
	* 
	*/
	public TMails findById(Long id);
	
	/**
	* The method updates the TMails record by an id.
	* The method throws BackendErrorsException with detail message 
	* if tpeopleId or emailType is null
	* 
	* @param id
	* @param tpeopleId
	* @param emailType
	* @param email
	* @throws BackendErrorsException
	*/
	public TMails update(Long id, Long tpeopleId, String emailType, String email) throws BackendErrorsException;

}
