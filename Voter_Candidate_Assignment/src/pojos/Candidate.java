package pojos;

import javax.persistence.*;

@Entity
@Table(name = "new_candidate")
public class Candidate extends AbstractEntity {
	
	@Column(name = "candidate_name", length = 20)
	String candidateName;
	
	@Column(name = "candidate_party", length = 20, unique = true)
	String candidateParty;
	
	@Column(name = "candidate_votes")
	int candidateVotes = 0;

	public Candidate() {
		System.out.println("In CTOR of " + getClass().getName());
	}

	public Candidate(String candidateName, String candidateParty) {		
		this.candidateName = candidateName;
		this.candidateParty = candidateParty;
	}

	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public String getCandidateParty() {
		return candidateParty;
	}

	public void setCandidateParty(String candidateParty) {
		this.candidateParty = candidateParty;
	}

	public int getCandidateVotes() {
		return candidateVotes;
	}

	public void setCandidateVotes(int candidateVotes) {
		this.candidateVotes = candidateVotes;
	}

	@Override
	public String toString() {
		return "Candidate [ ID=" + getId() +", Name=" + candidateName + ", Party=" + candidateParty + ", Votes="
				+ candidateVotes + "]";
	}
	
	
	
	
}
