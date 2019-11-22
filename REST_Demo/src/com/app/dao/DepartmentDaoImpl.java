package com.app.dao;

import java.util.List;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Department;

@Repository
@Transactional
public class DepartmentDaoImpl implements IDepartmentDAO {

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<Department> getDepartmentList() {
		String jpql="SELECT objDept FROM Department objDept";
		return sessionFactory.getCurrentSession().createQuery(jpql, Department.class).getResultList();		
	}
	@Override
	public String createDept(Department objDept) {
		Session session=sessionFactory.getCurrentSession();
		Long id=(Long)session.save(objDept);
		if(id!=null)
			return "New Department added";
		return "No department added";
	}

}
