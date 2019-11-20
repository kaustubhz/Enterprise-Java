package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.*;
@Entity
@Table(name="my_employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="emp_id")
	private Integer empId;
	
	@Column(name = "emp_name",length = 20)
	private String empName;
	
	@Column(name = "emp_email",length = 20,unique = true)
	private String empEmail;
	
	@Column(name="emp_salary")
	private double empSalary;
	
	@Column(name="emp_dob")
	private LocalDate empDOB;
	
	@ManyToOne
	@JoinColumn(name = "dept_id")	
	private Department deptId;
	
	public Employee() {
	System.out.println("In CTOR of "+getClass().getName());
	}

	public Employee(String empName, String empEmail, double empSalary, LocalDate empDOB) {
		super();
		this.empName = empName;
		this.empEmail = empEmail;
		this.empSalary = empSalary;
		this.empDOB = empDOB;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public double getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}

	public LocalDate getEmpDOB() {
		return empDOB;
	}

	public void setEmpDOB(LocalDate empDOB) {
		this.empDOB = empDOB;
	}
	
	

	public Department getDeptId() {
		return deptId;
	}

	public void setDeptId(Department deptId) {
		this.deptId = deptId;
	}

	public void setDepartment(Department newDepartment)
	{
		deptId=newDepartment;
	}
	@Override
	public String toString() {
		return "Employee [ ID=" + empId + ", Name=" + empName + ", Email=" + empEmail + ", Salary="
				+ empSalary + ", DOB=" + empDOB + "]";
	}
	
	
}
