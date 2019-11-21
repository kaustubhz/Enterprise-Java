package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.dao.IDepartmentDao;

@Controller
@RequestMapping("/dept") //Optional
public class DepartmentController {

	@Autowired
	private IDepartmentDao dao;
	
	@GetMapping("/list")
	public String showAllDepartments(Model map)
	{
		System.out.println("Inside showAllDepartments of "+getClass().getName());
		map.addAttribute("deptlist", dao.listAllDepartments());
		System.out.println("Map value:" +map);
		return "/dept/list";
	}
}
