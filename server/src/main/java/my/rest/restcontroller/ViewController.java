package my.rest.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import my.rest.model.tables.TPeople;
import my.rest.service.TPeopleService;

@Controller
public class ViewController {

	@Autowired
	TPeopleService tPeopleService;

	@RequestMapping("/")
	public String listContact(Model model) {
		List<TPeople> tpeopleList = tPeopleService.findAll();
		model.addAttribute("tpeopleList", tpeopleList);
		return "index";
	}

}
