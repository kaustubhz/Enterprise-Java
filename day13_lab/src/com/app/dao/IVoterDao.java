package com.app.dao;

import com.app.pojos.Voter;

public interface IVoterDao {
	Voter authenticateVoter(String email,String password);
	//i/p detached voter ref --kept in Java bean (Http session)
    String updateVotingStatus(Voter v);
}
