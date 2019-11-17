package dao;

import static utils.HibernateUtils.*;
import pojos.*;

import org.hibernate.*;


public class VoterDAOImpl implements IVoterDAO {
	
	@Override
	public String authenticateVoter(String email, String password) {
		String message="Unable to find Voter";
		Session session=getSessionFactory().getCurrentSession();
		Transaction transaction=session.beginTransaction();
		try{
			String jpql="SELECT objVoter FROM Voter objVoter WHERE objVoter.voterEmail= :email AND objVoter.voterPassword= :pass";
			Voter voter=session.createQuery(jpql, Voter.class).setParameter("email", email).setParameter("pass", password).getSingleResult();
			if(voter!=null)
			{
				message="Voter found by ID="+voter.getId();
			}
			transaction.commit();
		}
		
		catch(HibernateException ex) {
			if(transaction!=null)
			{
				transaction.rollback();
			}
			throw ex;
		}
		return message;
	}

}
