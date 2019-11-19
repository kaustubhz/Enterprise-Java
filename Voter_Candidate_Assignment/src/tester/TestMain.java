package tester;

import static utils.HibernateUtils.*;

import java.util.Scanner;

import org.hibernate.*;

import dao.VoterDAOImpl;
import pojos.Voter;

public class TestMain {

	public static void main(String[] args) {
		try(SessionFactory factory=getSessionFactory();
				Scanner sc=new Scanner(System.in)){
			VoterDAOImpl obj=new VoterDAOImpl();
			/*System.out.println("\nInside Main\nEmail Password");
			System.out.println(obj.authenticateVoter(sc.next(),sc.next()));*/
			/*
			 * System.out.println("\n Enter voter details:\nVoter email Voter password");
			 * obj.registerVoter(new Voter(sc.next(),sc.next()));
			 */
			/*
			 * System.out.println("\n Enter voterID: ");
			 * System.out.println(obj.updateVoterStatus(sc.nextInt()));
			 */
			
			System.out.println("\n Enter voterID: ");
			System.out.println(obj.removeVoterByID(sc.nextInt()));
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
