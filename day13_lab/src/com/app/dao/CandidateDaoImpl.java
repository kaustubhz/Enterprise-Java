package com.app.dao;

import java.util.List;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.*;

@Repository
@Transactional
public class CandidateDaoImpl implements ICandidateDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public CandidateDaoImpl() {
		System.out.println("Inside "+getClass().getName());
	}

	@Override
	public List<Candidate> getCandidateList() {
		String jpql = "select c from Candidate c";
		return sessionFactory.getCurrentSession().createQuery(jpql).getResultList();
		/*
		 * List<Candidate> l1 = null; // HS Session hs = getSf().getCurrentSession();
		 * Transaction tx = hs.beginTransaction(); try { l1 = hs.createQuery(jpql,
		 * Candidate.class).getResultList(); tx.commit(); } catch (RuntimeException e) {
		 * if (tx != null) tx.rollback(); throw e; }
		 */
		
	}

	@Override
	public String incrementVotes(int candidateId) {
		Session session=sessionFactory.getCurrentSession();
		Candidate objCandidate=session.get(Candidate.class, candidateId);
		if(objCandidate!=null)
		{
			objCandidate.setVotes(objCandidate.getVotes()+1);
			return "Vote count increased";
		}
		return "Vote count failed to increase";
		/*
		 * Session hs = getSf().getCurrentSession(); Transaction tx =
		 * hs.beginTransaction(); try { Candidate c = hs.get(Candidate.class,
		 * candidateId); // c -- PERSISTENT c.setVotes(c.getVotes() + 1); tx.commit(); }
		 * catch (RuntimeException e) { if (tx != null) tx.rollback(); throw e; }
		 */
		
	}

}
