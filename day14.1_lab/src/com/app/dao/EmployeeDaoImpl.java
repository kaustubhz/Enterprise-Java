package com.app.dao;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Employee;

@Repository
@Transactional
public class EmployeeDaoImpl implements IEmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public String registerEmployee(Employee employee,int deptId) {
		sessionFactory.getCurrentSession().save(employee);
		return "New employee added with ID="+employee.getEmpId();
	}

}
