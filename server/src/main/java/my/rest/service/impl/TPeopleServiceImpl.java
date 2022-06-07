package my.rest.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.rest.exception.BackendErrorsException;
import my.rest.model.tables.TPeople;
import my.rest.repository.TPeopleRepository;
import my.rest.service.TPeopleService;

@Service
public class TPeopleServiceImpl implements TPeopleService {

	@Autowired
	private TPeopleRepository tPeopleRepository;

	@Override
	public TPeople save(TPeople entity) throws BackendErrorsException {
		checkFullName(entity.getFullName());
		addZeroesToPin(entity);
		return tPeopleRepository.save(entity);
	}

	private void checkFullName(String fullName) throws BackendErrorsException {
		String regex = "(?=[а-яА-ЯёЁ]*[a-zA-Z])(?=[a-zA-Z]*[а-яА-ЯёЁ])|[\\wа-яА-ЯёЁ\\s-]+";
		boolean matched = Pattern.compile(regex).matcher(fullName).matches();
		if (!matched) {
			throw new BackendErrorsException("latinOrCyrillicWords");
		}
	}

	private void addZeroesToPin(TPeople entity) {
		if (entity.getPin() != null) {
			int pinLength = entity.getPin().length();
			if (pinLength < 10) {
				String prefix = "";
				for (int i = 0; i < (10 - pinLength); i++) {
					prefix += "0";
				}
				entity.setPin(prefix + entity.getPin());
			}
		}
	}

	@Override
	public void delete(TPeople entity) {
		tPeopleRepository.delete(entity);
	}

	@Override
	public List<TPeople> findTPeopleLikeName(String name) {
		String nameForSearch = name.toLowerCase();
		return tPeopleRepository.findTPeopleLikeName(nameForSearch);
	}

	@Override
	public List<TPeople> findAll() {
		return tPeopleRepository.findAll();
	}

	@Override
	public TPeople findById(Long id) {
		return tPeopleRepository.findById(id).orElseThrow(NoSuchElementException::new);
	}

	@Override
	public TPeople create(String fullName, String pin) throws BackendErrorsException {
		TPeople tpeople = new TPeople();
		fillTPeople(fullName, pin, tpeople);
		return save(tpeople);
	}

	@Override
	public TPeople update(Long id, String fullName, String pin) throws BackendErrorsException {
		TPeople tpeople = findById(id);
		fillTPeople(fullName, pin, tpeople);
		return save(tpeople);
	}

	private void fillTPeople(String fullName, String pin, TPeople tpeople) throws BackendErrorsException {
		if (fullName == null) {
			throw new BackendErrorsException("FullName is not filled!");
		}
		tpeople.setFullName(fullName);
		if (pin == null) {
			throw new BackendErrorsException("Pin is not filled!");
		}
		tpeople.setPin(pin);
	}

}
