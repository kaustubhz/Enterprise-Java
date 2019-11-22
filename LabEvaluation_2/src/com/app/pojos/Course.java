package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Course extends AbstracEntity {

	@Column(name="course_name",length = 20,unique = true)
	private String courseName;
	@Column(name = "course_price",precision = 2)
	private double coursePrice;
	
	@OneToMany(mappedBy = "courseId",orphanRemoval = true,cascade = CascadeType.ALL)
	List<Student> studentList=new ArrayList<>();
	
	public Course() {
	System.out.println("Inside CTOR of "+getClass().getName());
	}

	public Course(String courseName, double coursePrice) {
		super();
		this.courseName = courseName;
		this.coursePrice = coursePrice;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public double getCoursePrice() {
		return coursePrice;
	}

	public void setCoursePrice(double coursePrice) {
		this.coursePrice = coursePrice;
	}
	
}
