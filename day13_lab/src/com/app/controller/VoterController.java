package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dao.IVoterDao;
import com.app.pojos.Voter;

@Controller
@RequestMapping("/voter") // This is optional but recommended
public class VoterController {

//	Dependency
	@Autowired
	private IVoterDao dao;

	public VoterController() {
		System.out.println("\n In CTOR of " + getClass().getName()+dao);
	}

//	Request handling method
	@GetMapping("/login") //@=RequestMapping()
	public String showLoginForm() {
		System.out.println("In  showLoginForm of " + getClass().getName());
		return "/voter/login";
	}

	@PostMapping("/login")
	public String processLoginForm(@RequestParam String email, @RequestParam String password, Model map) {
		System.out.println("In processLoginForm() of" + getClass().getName());
		try {
			Voter objVoter = dao.authenticateVoter(email, password);
		} catch (RuntimeException e) {
			// Invalid login
			// Add an error message to model map --request scope
			map.addAttribute("message", "Invalid login, try again");
			return "/voter/login";
		}
		map.addAttribute("message","Successful login");
		return "/candidate/list";
	}

}
