package beans;

import java.util.ArrayList;
import java.util.List;

import dao.CandidateDaoImpl;
import pojos.Candidate;

public class CandidateBean {

	private Integer candidateId;
	private List<Candidate> candidates;

	private CandidateDaoImpl dao;

	public CandidateBean() {
		System.out.println("Inside Candidate Bean");
		candidates = new ArrayList<>();
		dao = new CandidateDaoImpl();
	}

	public List<Candidate> getCandidates() {
//		return candidates;
		return dao.getCandidateList();
	}
 
	public Integer getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Integer candidateId) {
		this.candidateId = candidateId;
	}

	public String updateVotes() {
		return dao.incrementVotes(candidateId);
	}

}
