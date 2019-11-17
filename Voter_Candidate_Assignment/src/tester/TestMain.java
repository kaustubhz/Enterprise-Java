package tester;

import static utils.HibernateUtils.*;

import java.util.Scanner;

import org.hibernate.*;

import dao.VoterDAOImpl;

public class TestMain {

	public static void main(String[] args) {
		try(SessionFactory factory=getSessionFactory();
				Scanner sc=new Scanner(System.in)){
			/*VoterDAOImpl obj=new VoterDAOImpl();
			System.out.println("\nInside Main\nEmail Password");
			System.out.println(obj.authenticateVoter(sc.next(),sc.next()));*/
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
