package beans;

import dao.VoterDAOImpl;
import pojos.Voter;

public class VoterBean {

	private String email,pass;
	private String message;
	
	private Voter voterDetails;
	
	private VoterDAOImpl dao;
	
	public VoterBean() {
	System.out.println("\n Default CTOR of "+getClass().getName());
	dao=new VoterDAOImpl();
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String validateVoter()
	{
		System.out.println("\n Validating voter details from "+getClass().getName());
		try {
			voterDetails=dao.authenticateVoter(email, pass);
			/*
			 * if(voterDetails.getVoterStatus().equals("YES")) {
			 * message="You already voted"; return "status"; }
			 */
			message="Login Successful";
			return "candidatelist";
		}
		catch (RuntimeException e) {
			System.out.println("Error is "+e);
			message="Invalid login";
			return "login";
		}
		
	}
	
	
}
