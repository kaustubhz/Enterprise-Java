package com.app.dao;

import com.app.pojos.Employee;

public interface IEmployeeDao {

	public String registerEmployee(Employee employee,int deptId);
}
