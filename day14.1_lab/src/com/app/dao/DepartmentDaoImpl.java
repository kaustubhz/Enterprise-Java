package com.app.dao;

import java.util.List;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Department;

@Repository
@Transactional
public class DepartmentDaoImpl implements IDepartmentDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Department> listAllDepartments() {
		String jpql="SELECT objDepartment FROM Department objDepartment";
		return sessionFactory.getCurrentSession().createQuery(jpql, Department.class).getResultList();
	}

}
