package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.dao.IStudentDao;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private IStudentDao dao;
}
