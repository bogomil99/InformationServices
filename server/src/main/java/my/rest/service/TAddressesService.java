package my.rest.service;

import my.rest.exception.BackendErrorsException;
import my.rest.model.tables.TAddresses;

public interface TAddressesService {

	public TAddresses save(TAddresses entity);

	public void delete(TAddresses entity);

	public TAddresses create(Long tpeopleId, String addrType, String addrInfo) throws BackendErrorsException;

	public TAddresses findById(Long id);

	public TAddresses update(Long id, Long tpeopleId, String addrType, String addrInfo) throws BackendErrorsException;

}
