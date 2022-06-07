package my.rest.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import my.rest.exception.BackendErrorsException;
import my.rest.model.tables.TAddresses;
import my.rest.model.tables.TMails;
import my.rest.model.tables.TPeople;
import my.rest.service.TAddressesService;
import my.rest.service.TMailsService;
import my.rest.service.TPeopleService;

/**
 * @author bborisov
 */
@RestController
public class RestStarter {

	@Autowired
	TPeopleService tPeopleService;
	@Autowired
	TMailsService tMailsService;
	@Autowired
	TAddressesService tAddressesService;

	@RequestMapping("/searchTPeopleByName")
	public String getStringValue(String name) {
		List<TPeople> resultList = tPeopleService.findTPeopleLikeName(name);
		return toJson(resultList);
	}

	@RequestMapping("/createTPeople")
	public String createTPeople(String fullName, String pin) {
		try {
			TPeople tpeople = tPeopleService.create(fullName, pin);
			return toJson(tpeople);
		} catch (BackendErrorsException e) {
			return e.getMessage();
		}
	}

	@RequestMapping("/updateTPeople")
	public String updateTPeople(Long id, String fullName, String pin) {
		try {
			TPeople tpeople = tPeopleService.update(id, fullName, pin);
			return toJson(tpeople);
		} catch (BackendErrorsException e) {
			return e.getMessage();
		}
	}

	@RequestMapping("/deleteTPeople")
	public String deleteTPeople(Long id, String fullName, String pin) {
		TPeople tpeople = tPeopleService.findById(id);
		tPeopleService.delete(tpeople);
		return "TPeople " + tpeople.getFullName() + " was deleted!";
	}

	@RequestMapping("/createTMail")
	public String createTMail(Long tpeopleId, String emailType, String email) {
		try {
			TMails tmails = tMailsService.create(tpeopleId, emailType, email);
			return toJson(tmails);
		} catch (BackendErrorsException e) {
			return e.getMessage();
		}
	}

	@RequestMapping("/updateTMail")
	public String updateTMail(Long id, Long tpeopleId, String emailType, String email) {
		try {
			TMails tmails = tMailsService.update(id, tpeopleId, emailType, email);
			return toJson(tmails);
		} catch (BackendErrorsException e) {
			return e.getMessage();
		}
	}

	@RequestMapping("/deleteTMail")
	public String deleteTMail(Long id) {
		TMails tmail = tMailsService.findById(id);
		tMailsService.delete(tmail);
		return "TMail for user " + tmail.getTPeople().getFullName() + " with emailType " + tmail.getEmailType()
				+ " was deleted!";
	}

	@RequestMapping("/createTAddress")
	public String createTAddress(Long tpeopleId, String addrType, String addrInfo) {
		try {
			TAddresses taddress = tAddressesService.create(tpeopleId, addrType, addrInfo);
			return toJson(taddress);
		} catch (BackendErrorsException e) {
			return e.getMessage();
		}
	}

	@RequestMapping("/updateTAddress")
	public String updateTAddress(Long id, Long tpeopleId, String addrType, String addrInfo) {
		try {
			TAddresses taddress = tAddressesService.update(id, tpeopleId, addrType, addrInfo);
			return toJson(taddress);
		} catch (BackendErrorsException e) {
			return e.getMessage();
		}
	}

	@RequestMapping("/deleteTAddress")
	public String deleteTAddress(Long id) {
		TAddresses taddress = tAddressesService.findById(id);
		tAddressesService.delete(taddress);
		return "TAddress for user " + taddress.getTPeople().getFullName() + " with addrType " + taddress.getAddrType()
				+ " was deleted!";
	}

	private String toJson(Object obj) {
		Gson gson = new Gson();
		return gson.toJson(obj);
	}

	private String toJson(List<?> objList) {
		String listOfObj = "";
		Gson gson = new GsonBuilder().serializeNulls().create();
		for (Object obj : objList) {
			listOfObj += gson.toJson(obj);
		}
		if (!listOfObj.isEmpty()) {
			listOfObj = listOfObj.substring(0, listOfObj.length() - 1);
		}
		return listOfObj;
	}

}
