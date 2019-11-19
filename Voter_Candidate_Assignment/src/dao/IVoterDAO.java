package dao;

import pojos.Voter;

public interface IVoterDAO {
	Voter authenticateVoter(String email,String password);
	String registerVoter(Voter objVoter);
	String updateVoterStatus(int voterId);
	String removeVoterByID(int voterId);

}
