package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Candidate;
import static utils.HibernateUtils.*;

public class CandidateDAOImpl implements ICandidateDAO {

	@Override
	public List<Candidate> getCandidateList() {
		System.out.println("\n Inside candidate list method");
		String jpql="SELECT objCandidate FROM Candidate objCandidate";
		List<Candidate> candidateList=null;
		Session session=getSessionFactory().getCurrentSession();
		Transaction transaction=session.beginTransaction();
		try {
			
			candidateList=session.createQuery(jpql,Candidate.class).getResultList();
			transaction.commit();
		}
		catch(RuntimeException e)
		{
			if(transaction!=null)
				transaction.rollback();
			throw e;
		}
		return candidateList;
	}

}
