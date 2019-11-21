package com.app.dao;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Department;
import com.app.pojos.Employee;

@Repository
@Transactional
public class EmployeeDaoImpl implements IEmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public String registerEmployee(Employee employee,int deptId) {
		String message="Employee registration failed";
		Department objDept=sessionFactory.getCurrentSession().get(Department.class, deptId);
		System.out.println("Department is="+objDept);
		if(objDept!=null)
		{
			objDept.addEmployee(employee);
			message="Employee registerd successfully with ID";
			System.out.println(message+employee.getEmpId());
			return "Success";
		}
//		sessionFactory.getCurrentSession().save(employee);
		return "FAIL";
	}

}
