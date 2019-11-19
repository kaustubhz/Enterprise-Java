package com.app.dao;

import com.app.pojos.Voter;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class VoterDaoImpl implements IVoterDao {

//	Dependency
	@Autowired
	private SessionFactory sessionFactory;

	public VoterDaoImpl() {
		System.out.println("Inside " + getClass().getName());
	}

	@Override
	public Voter authenticateVoter(String email, String password) {
		String jpql = "select v from Voter v where v.email=:em and v.pass=:pa";

		// HS

		return sessionFactory.getCurrentSession().createQuery(jpql, Voter.class).setParameter("em", email)
				.setParameter("pa", password).getSingleResult();
		
	}

	@Override
	public String updateVotingStatus(Voter v) { 
		v.setStatus("YES");
		sessionFactory.getCurrentSession().update(v);
		/*
		 * Session hs = getSf().getCurrentSession(); Transaction tx =
		 * hs.beginTransaction(); try { // re attach detached POJO with L1 cache //
		 * detached--->persistent (update) // v --detached hs.update(v);// v
		 * --persistent v.setStatus("YES"); ; tx.commit(); } catch (RuntimeException e)
		 * { if (tx != null) tx.rollback(); throw e; }
		 */
		return "Updated";
	}

}
