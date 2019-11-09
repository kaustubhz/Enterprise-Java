package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.VotingDaoImpl;
import pojos.Candidate;

@WebServlet("/alldetails")
public class AllDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VotingDaoImpl dao;
	public HttpSession hs;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("In candidate init " + Thread.currentThread());
		try {
			dao = new VotingDaoImpl();
		} catch (Exception e) {
			throw new ServletException("Something went wrong in doInit()", e);
		}
	}

	public void destroy() {
		System.out.println("In all details destroy " + Thread.currentThread());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try(PrintWriter pw=response.getWriter()) {
			ArrayList<Candidate> list=(ArrayList<Candidate>)dao.getCandidateList();
			hs=request.getSession();
			pw.println("<h3>Candidate list</h3>");
			pw.println("<table border=1 cellspacing=2 cellpadding=2><tr><th>Candidate ID</th><th>Candidate Name</th><th>Candidate Party</th><th>Candidate Votes</th></tr>");
			for(Candidate c:list)
			{				
				pw.println("<tr>");
				pw.println("<td>"+c.getId()+"</td>"+"<td>"+c.getName()+"</td>"+"<td>"+c.getPoliticalParty()+"</td>"+"<td>"+c.getVotes()+"</td>");
				pw.println("</tr>");
			}
			pw.println("</table>");
			
			hs.invalidate();
			pw.print("<p align=center><a href='index.html'>Logout</a></p>");
			
		} catch (Exception e) {
			throw new ServletException("Something went wrong in showing all details", e);
		}
	}

}
