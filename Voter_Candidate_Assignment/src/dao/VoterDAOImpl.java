package dao;

import static utils.HibernateUtils.*;
import pojos.*;

import org.hibernate.*;


public class VoterDAOImpl implements IVoterDAO {
	
	@Override
	public Voter authenticateVoter(String email, String password) {
		String message="Unable to find Voter";
		Session session=getSessionFactory().getCurrentSession();
		Voter voter=null;
		Transaction transaction=session.beginTransaction();
		try{
			String jpql="SELECT objVoter FROM Voter objVoter WHERE objVoter.voterEmail= :email AND objVoter.voterPassword= :pass";
			voter=session.createQuery(jpql, Voter.class).setParameter("email", email).setParameter("pass", password).getSingleResult();
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
		return voter;
	}

	@Override
	public String registerVoter(Voter objVoter) {
		String message="Unable to register Voter";
		Session session=getSessionFactory().getCurrentSession();
		Transaction transaction=session.beginTransaction();
		try{
			Integer id=(Integer)session.save(objVoter);
//			System.out.println("ID="+id);
			message="Voter registered with ID="+id;
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

	@Override
	public String updateVoterStatus(int voterId) {
		String message="Failed to update Voter status";
		Session session=getSessionFactory().getCurrentSession();
		Transaction transaction=session.beginTransaction();
		try{
			String jpql="SELECT objVoter FROM Voter objVoter WHERE objVoter.id= :voterId";
			Voter objVoter=session.createQuery(jpql, Voter.class).setParameter("voterId", voterId).getSingleResult();
			objVoter.setVoterStatus("YES");
			message=objVoter.getVoterEmail()+" Voter status is updated";
			transaction.commit();
		}catch(HibernateException ex) {
			if(transaction!=null)
			{
				transaction.rollback();
			}
			throw ex;
		}
		return message;
	}

	@Override
	public String removeVoterByID(int voterId) {
		String message="Failed to delete Voter";
		Session session=getSessionFactory().getCurrentSession();
		Transaction transaction=session.beginTransaction();
		try{
			String jpql="SELECT objVoter FROM Voter objVoter WHERE objVoter.id= :voterId";
			Voter objVoter=session.createQuery(jpql, Voter.class).setParameter("voterId", voterId).getSingleResult();
			message=objVoter.getVoterEmail()+" is removed successfully";
			session.remove(objVoter);			
			transaction.commit();
		}catch(HibernateException ex) {
			if(transaction!=null)
			{
				transaction.rollback();
			}
			throw ex;
		}
		return message;
	}

}
