package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.dao.ICourseDao;

@Controller
@RequestMapping("/courses")
public class CourseController {

	@Autowired
	ICourseDao dao;
	
	@GetMapping("/showcourses")
	public String showAllCourses(Model map)
	{
		System.out.println("Inside showAllCourses of "+getClass().getName());
		map.addAttribute("courses", dao.courseList());
		return "/courses/showcourses";
	}
}
