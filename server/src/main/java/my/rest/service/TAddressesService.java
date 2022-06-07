package my.rest.service;

import my.rest.exception.BackendErrorsException;
import my.rest.model.tables.TAddresses;

/**
 * @author bborisov
 */
public interface TAddressesService {

	/**
	* Saving record to a TAddresses table.
	* 
	* @param entity
	* @throws BackendErrorsException
	*/
	public TAddresses save(TAddresses entity);

	/**
	* Deletes record by TAddresses table
	* 
	* @param entity
	*/
	public void delete(TAddresses entity);

	/**
	* The method creates a new record in TAddresses table.
	* The method throws BackendErrorsException with detail message 
	* if tpeopleId or addrType is null
	* 
	* @param tpeopleId
	* @param addrType
	* @param addrInfo
	* @throws BackendErrorsException
	*/
	public TAddresses create(Long tpeopleId, String addrType, String addrInfo) throws BackendErrorsException;

	/**
	* Returns TAddresses record by an id
	* 
	*/
	public TAddresses findById(Long id);

	/**
	* The method updates the TAddresses record by an id.
	* The method throws BackendErrorsException with detail message 
	* if tpeopleId or addrType is null
	* 
	* @param id
	* @param tpeopleId
	* @param addrType
	* @param addrInfo
	* @throws BackendErrorsException
	*/
	public TAddresses update(Long id, Long tpeopleId, String addrType, String addrInfo) throws BackendErrorsException;

}
