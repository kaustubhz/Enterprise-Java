package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Student extends AbstracEntity {

	@Column(name = "name",length = 20,nullable = false)
	private String studentName;
	@Column(name="email",unique = true)
	private String studentEmail;
	@Column(name="cgpa",precision = 1)
	private double studentCGPA;
	@Column(name="DoB")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate studentDoB;
	
//	Many to One relationship
	@ManyToOne
	private Course courseId;
	
	public Student() {
		System.out.println("Inside CTOR of "+getClass().getName());
	}

	public Student(String studentName, String studentEmail, double studentCGPA, LocalDate studentDoB) {
		super();
		this.studentName = studentName;
		this.studentEmail = studentEmail;
		this.studentCGPA = studentCGPA;
		this.studentDoB = studentDoB;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public double getStudentCGPA() {
		return studentCGPA;
	}

	public void setStudentCGPA(double studentCGPA) {
		this.studentCGPA = studentCGPA;
	}

	public LocalDate getStudentDoB() {
		return studentDoB;
	}

	public void setStudentDoB(LocalDate studentDoB) {
		this.studentDoB = studentDoB;
	}
	
	
}
