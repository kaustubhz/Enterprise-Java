package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.VotingDaoImpl;
import pojos.Candidate;
import pojos.Voter;

/**
 * Servlet implementation class CandidateList
 */
@WebServlet("/candidatelist")
public class CandidateList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VotingDaoImpl dao;
	public HttpSession hs;
	@Override
	public void init() throws ServletException {
		System.out.println("In candidate init "+Thread.currentThread());
		try{
			dao=new VotingDaoImpl();
		}catch (Exception e) {
			throw new ServletException("Something went wrong in doInit()",e);
		} 
		
	}
	
	@Override
	public void destroy() {
		System.out.println("In candidate destroy "+Thread.currentThread());
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession hs=request.getSession();
		List<Candidate> listCandidate=new ArrayList<>();
		try(PrintWriter pw=response.getWriter()) {
			Voter obj1=(Voter)hs.getAttribute("voter");
			
//			System.out.println(obj1.getEmail());
			pw.print("<h1 align=center>Hello, "+obj1.getEmail()+"</h1>");
			pw.print("<form action='logout'>");
			for(Candidate obj:listCandidate)
			{
				pw.print("<input type=radio name=rdbtn value="+obj.getId()+">"+obj.getName()+"</input><br/>");				
			}
			pw.print("<input type=submit value='Submit' />");
			pw.print("</form>");
			hs=request.getSession();
//			hs.setAttribute("candidateid", request.getAttribute("rdbtn"));			
		} catch (Exception e) {
			throw new ServletException("Something went wrong while fetching candidate list",e);
		}
		
	}

}
