package my.rest.service.impl;

import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.rest.exception.BackendErrorsException;
import my.rest.model.tables.TMails;
import my.rest.model.tables.TPeople;
import my.rest.repository.TMailsRepository;
import my.rest.service.TMailsService;
import my.rest.service.TPeopleService;

/**
 * @author bborisov
 */
@Service
public class TMailsServiceImpl implements TMailsService {

	@Autowired
	private TMailsRepository tMailsRepository;
	@Autowired
	private TPeopleService tPeopleService;

	@Override
	public TMails save(TMails entity) throws BackendErrorsException {
		checkForCorrectEmail(entity.getEmail());
		return tMailsRepository.save(entity);
	}

	private void checkForCorrectEmail(String email) throws BackendErrorsException {
		String mailRegex = "^[\\w.-]+@[\\w-]+\\.[\\w-]+$";
		Pattern pattern = Pattern.compile(mailRegex);
		Matcher matcher = pattern.matcher(email);
		if (!matcher.matches()) {
			throw new BackendErrorsException("email");
		}
	}

	@Override
	public void delete(TMails entity) {
		tMailsRepository.delete(entity);
	}

	@Override
	public TMails create(Long tpeopleId, String emailType, String email) throws BackendErrorsException {
		TMails tmails = new TMails();
		fillTMail(tpeopleId, emailType, email, tmails);
		return save(tmails);
	}

	@Override
	public TMails findById(Long id) {
		return tMailsRepository.findById(id).orElseThrow(NoSuchElementException::new);
	}

	@Override
	public TMails update(Long id, Long tpeopleId, String emailType, String email) throws BackendErrorsException {
		TMails tmails = findById(id);
		fillTMail(tpeopleId, emailType, email, tmails);
		return save(tmails);
	}
	
	private void fillTMail(Long tpeopleId, String emailType, String email, TMails tmails)
			throws BackendErrorsException {
		tmails.setEmail(email);
		if (emailType == null) {
			throw new BackendErrorsException("EmailType is not filled!");
		}
		tmails.setEmailType(emailType);
		if (tpeopleId == null) {
			throw new BackendErrorsException("TpeopleId is not filled!");
		}
		TPeople tpeople = tPeopleService.findById(tpeopleId);
		tmails.setTPeople(tpeople);
	}

}
