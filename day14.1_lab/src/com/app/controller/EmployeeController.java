package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.app.dao.IEmployeeDao;
import com.app.pojos.Employee;

@Controller
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	private IEmployeeDao dao;

	@GetMapping("/register")
	public String showRegForm(Model map) {
		System.out.println("inside show reg form " + getClass().getName());
		map.addAttribute("employee", new Employee());
		return "/emp/register";
	}

	@PostMapping("/register")
	public String processRegForm(Employee e, @RequestParam Integer deptartmentId, Model map) {
		System.out.println("inside Post reg form " + getClass().getName());
		System.out.println("Map values=" + map);
		/* System.out.println(" Flash Map values="+map); */
		/* map.addAttribute("deptid",deptartmentId); */
		System.out.println("department id=" + deptartmentId);

		if (dao.registerEmployee(e,deptartmentId).equals("Success"))
			return "redirect:/emp/status";

		 return "/emp/register";
	}


@GetMapping("/status")
public String showStatus() {
	System.out.println("inside show status " + getClass().getName());
	return "/emp/status";
}
}