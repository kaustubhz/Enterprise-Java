package com.app.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
	public String showRegForm(@RequestParam int deptId,Model map)
	{
		System.out.println("inside show reg form "+getClass().getName());
		map.addAttribute("deptid",deptId);
		return "/emp/register";
	}
	
	@PostMapping("/register")
	public String processRegForm(@RequestParam String empName,@RequestParam String empEmail,@RequestParam String empSalary,@RequestParam String empDOB, Model map)
	{
		System.out.println("inside Post reg form "+getClass().getName());
		Employee objEmployee=new Employee(empName,empEmail,Double.parseDouble(empSalary),LocalDate.parse(empDOB,DateTimeFormatter.ofPattern("yyyy-mm-dd")));
		dao.registerEmployee(objEmployee,(int)map.getAttribute("deptid"));
//		map.addAttribute(deptId);
		return "/emp/register";
	}
}
