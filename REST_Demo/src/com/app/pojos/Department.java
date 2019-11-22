package com.app.pojos;

import javax.persistence.*;

@Entity
@Table(name = "my_department")
public class Department extends AbstractEntity {
	@Column(name = "department_name", unique = true, length = 20)
	private String departmentName;
	@Column(name = "department_location", length = 20)
	private String departmentLocation;

	public Department() {
	System.out.println("\n Inside CTOR of "+getClass().getName());
	}

	public Department(String departmentName, String departmentLocation) {	
		this.departmentName = departmentName;
		this.departmentLocation = departmentLocation;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentLocation() {
		return departmentLocation;
	}

	public void setDepartmentLocation(String departmentLocation) {
		this.departmentLocation = departmentLocation;
	}

	@Override
	public String toString() {
		return "Department [ ID" + getId() +"Name=" + departmentName + ", Location=" + departmentLocation
				+ " ]";
	}
	
	
}
