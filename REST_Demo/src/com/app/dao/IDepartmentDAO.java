package com.app.dao;

import java.util.List;

import com.app.pojos.Department;

public interface IDepartmentDAO {

	List<Department> getDepartmentList();
	String createDept(Department objDept);
}
