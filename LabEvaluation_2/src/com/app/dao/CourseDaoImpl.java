package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Course;

@Repository
@Transactional
public class CourseDaoImpl implements ICourseDao {

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<Course> courseList() {
		String jpql="SELECT objCourse FROM Course objCourse";
		return sessionFactory.getCurrentSession().createQuery(jpql, Course.class).getResultList();
	}

}
