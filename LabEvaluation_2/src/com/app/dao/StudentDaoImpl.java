package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Student;

@Repository
@Transactional
public class StudentDaoImpl implements IStudentDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public String registerStudent(Student objStudent) {
		Long id=(Long)sessionFactory.getCurrentSession().save(objStudent);
		if(id!=null)
			return "Student registered";
		return "Registration failure";
	}

}
