package com.app.dao;

import java.util.List;

import com.app.pojos.Candidate;

public interface ICandidateDao {
	List<Candidate> getCandidateList();
	String incrementVotes(int candidateId);

}
