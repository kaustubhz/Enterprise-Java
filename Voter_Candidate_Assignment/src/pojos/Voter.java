package pojos;

import javax.persistence.*;

@Entity
@Table(name = "voter")
public class Voter extends AbstractEntity {

	@Column(name = "voter_email", unique = true, length = 20)
	private String voterEmail;
	@Column(name = "voter_password", length = 20)
	private String voterPassword;
	@Column(name = "voter_status",length = 3)
	private String voterStatus = "NO";

	public Voter() {
		System.out.println("In CTOR of " + getClass().getName());
	}

	public Voter(String voterEmail, String voterPassword) {		
		this.voterEmail = voterEmail;
		this.voterPassword = voterPassword;
	}
			
	public String getVoterEmail() {
		return voterEmail;
	}

	public void setVoterEmail(String voterEmail) {
		this.voterEmail = voterEmail;
	}

	public String getVoterPassword() {
		return voterPassword;
	}

	public void setVoterPassword(String voterPassword) {
		this.voterPassword = voterPassword;
	}

	public String getVoterStatus() {
		return voterStatus;
	}

	public void setVoterStatus(String voterStatus) {
		this.voterStatus = voterStatus;
	}

	@Override
	public String toString() {
		return "Voter [ ID="+getId()+" Email=" + voterEmail + ", Status=" + voterStatus + "]";
	}
		

}
