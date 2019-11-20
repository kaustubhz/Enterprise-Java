package beans;

import java.util.List;

import dao.CandidateDAOImpl;
import pojos.Candidate;
public class CandidateBean {

	private Integer radID;
	private List<Candidate> candidateList;
	private CandidateDAOImpl dao;
	
	public CandidateBean() {
	System.out.println("\n In CTOR of "+getClass().getName());
	dao=new CandidateDAOImpl();
	}

	public Integer getRadID() {
		return radID;
	}

	public void setRadID(Integer radID) {
		this.radID = radID;
	}

	public List<Candidate> getCandidateList() {
		return dao.getCandidateList();
	}
	
}
