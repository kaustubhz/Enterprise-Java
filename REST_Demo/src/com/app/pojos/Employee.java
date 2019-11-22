package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "my_employee")
public class Employee extends AbstractEntity {

	@Column(name = "employee_name", length = 20)
	private String employeeName;
	
	@Column(name = "employee_email", length = 20, unique = true)
	private String employeeEmail;
	
	@Column(name = "employee_salary", precision = 2)
	private double employeeSalary;
	
	@Column(name = "employee_dob")
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private LocalDate employeeDoB;
	
	@ManyToOne
	@JoinColumn(name = "dept_id")
	private Department departmentId;
	
	public Employee() {
	System.out.println("In CTOR of "+getClass().getName());
	}

	public Employee(String employeeName, String employeeEmail, double employeeSalary, LocalDate employeeDoB) {
		super();
		this.employeeName = employeeName;
		this.employeeEmail = employeeEmail;
		this.employeeSalary = employeeSalary;
		this.employeeDoB = employeeDoB;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public double getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
	

	public LocalDate getEmployeeDoB() {
		return employeeDoB;
	}

	public void setEmployeeDoB(LocalDate employeeDoB) {
		this.employeeDoB = employeeDoB;
	}
	
	public void setDepartment(Department deptId) {
		this.departmentId=deptId;
	}

	@Override
	public String toString() {
		return "Employee [ id=" + id + " Name=" + employeeName + ", Email=" + employeeEmail + ", Salary="
				+ employeeSalary + ", DoB=" + employeeDoB + "]";
	}
	
}
