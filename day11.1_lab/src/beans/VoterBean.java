package beans;

import dao.VoterDaoImpl;
import pojos.Voter;

public class VoterBean {
	private String email,pass;
	private Voter objVoter;
	private VoterDaoImpl objVoterDao;
	
	
	public VoterBean() {
		System.out.println("Inside Voter Bean");
		objVoterDao=new VoterDaoImpl();
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
	
	public Voter getObjVoter() {
		return objVoter;
	}

	public void setObjVoter(Voter objVoter) {
		this.objVoter = objVoter;
	}

	public String validateVoter()
	{
		try
		{
		Voter objVoter=objVoterDao.authenticateVoter(email, pass);
		if(objVoter!=null)
		{
			return "candidatelist";
		}
		return "login";
		}
		catch (RuntimeException e) {
			System.out.println("\n Error is: "+e);
			return "login";
		}
		
	}
	
}
