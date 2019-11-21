package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
@Entity
@Table(name="my_department")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="dept_id")
	private Integer deptartmentId;
	
	public Integer getDeptartmentId() {
		return deptartmentId;
	}

	public void setDeptartmentId(Integer deptartmentId) {
		this.deptartmentId = deptartmentId;
	}

	@Column(name = "dept_name",length = 20,unique = true)
	private String departName;
	
	@Column(name = "dept_location",length = 20)
	private String departLocation;
	
	@OneToMany(mappedBy = "deptId",cascade = CascadeType.ALL,orphanRemoval = true)
	List<Employee> employeeList=new ArrayList<>();
	
	public Department() {
	System.out.println("Inside CTOR of "+getClass().getName());
	}

	public Department(String departName, String departLocation) {
		super();
		this.departName = departName;
		this.departLocation = departLocation;
	}


	public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}

	public String getDepartLocation() {
		return departLocation;
	}

	public void setDepartLocation(String departLocation) {
		this.departLocation = departLocation;
	}

	@Override
	public String toString() {
		return "Department [ ID=" + deptartmentId + ", Name=" + departName + ", Location=" + departLocation
				+ "]";
	}
	
	public void addEmployee(Employee newEmployee)
	{
		employeeList.add(newEmployee);
		newEmployee.setDepartment(this);
	}
	
	public void removeEmployee(Employee employee) {		
		employeeList.remove(employee);
		employee.setDepartment(null);		
	}
}
