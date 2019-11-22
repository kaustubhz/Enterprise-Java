package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.dao.IDepartmentDAO;

@Controller
@RequestMapping("/departments")
public class DeptController {

	@Autowired
	private IDepartmentDAO dao;
	
	@GetMapping("/department")
	public String getDepartments(Model map)
	{
		System.out.println("Inside getDepartments of "+getClass().getName());
		map.addAttribute("deptlist", dao.getDepartmentList());
		return "/departments/department";
	}
}
