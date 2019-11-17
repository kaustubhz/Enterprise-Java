package beans;

import java.util.ArrayList;
import java.util.List;

import dao.CandidateDaoImpl;
import pojos.Candidate;

public class CandidateBean {

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
 

}
