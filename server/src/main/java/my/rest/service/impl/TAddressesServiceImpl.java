package my.rest.service.impl;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.rest.exception.BackendErrorsException;
import my.rest.model.tables.TAddresses;
import my.rest.model.tables.TPeople;
import my.rest.repository.TAddressesRepository;
import my.rest.service.TAddressesService;
import my.rest.service.TPeopleService;

@Service
public class TAddressesServiceImpl implements TAddressesService {

	@Autowired
	private TAddressesRepository tAddressesRepository;
	@Autowired
	private TPeopleService tPeopleService;

	@Override
	public TAddresses save(TAddresses entity) {
		return tAddressesRepository.save(entity);
	}

	@Override
	public void delete(TAddresses entity) {
		tAddressesRepository.delete(entity);
	}

	@Override
	public TAddresses create(Long tpeopleId, String addrType, String addrInfo) throws BackendErrorsException {
		TAddresses taddress = new TAddresses();
		fillTAddress(tpeopleId, addrType, addrInfo, taddress);
		return save(taddress);
	}

	@Override
	public TAddresses findById(Long id) {
		return tAddressesRepository.findById(id).orElseThrow(NoSuchElementException::new);
	}

	@Override
	public TAddresses update(Long id, Long tpeopleId, String addrType, String addrInfo) throws BackendErrorsException {
		TAddresses taddress = findById(id);
		fillTAddress(tpeopleId, addrType, addrInfo, taddress);
		return save(taddress);
	}

	private void fillTAddress(Long tpeopleId, String addrType, String addrInfo, TAddresses taddress)
			throws BackendErrorsException {
		taddress.setAddrInfo(addrInfo);
		if (addrType == null) {
			throw new BackendErrorsException("AddrType is not filled!");
		}
		taddress.setAddrType(addrType);
		if (tpeopleId == null) {
			throw new BackendErrorsException("TpeopleId is not filled!");
		}
		TPeople tpeople = tPeopleService.findById(tpeopleId);
		taddress.setTPeople(tpeople);
	}

}
