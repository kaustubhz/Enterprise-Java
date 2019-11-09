package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.VotingDaoImpl;
import pojos.Voter;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VotingDaoImpl dao;
	public HttpSession hs;
	
	public void init() throws ServletException {
		System.out.println("In logout init "+Thread.currentThread());
		try{
			dao=new VotingDaoImpl();
		}catch (Exception e) {
			throw new ServletException("Something went wrong in doInit()",e);
		} 
	}
	
	public void destroy() {
		System.out.println("In logout destroy "+Thread.currentThread());
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
//		HttpSession hs=request.getSession();
		try(PrintWriter pw=response.getWriter()) {
			hs=request.getSession();
			int candidateId=Integer.parseInt(request.getParameter("rdbtn"));
			Voter v=(Voter)hs.getAttribute("voter");
			try {
				String status=dao.incVotesUpdateStatus(candidateId,v.getId());
				if(status.equals("Success"))
				{
					hs.invalidate();
					pw.print("<h2 align=center>Thanks for voting</h2><p align=center><a href='index.html'>Logout</a></p>");
				}
				else
				{
					pw.print("<h2 align=center>Voting failed!!!</h2><p align=center><a href='index.html'>Logout</a></p>");
				}
			} catch (Exception e) {
				throw new ServletException("Something went wrong while updating voting status",e);
			}
		}
	}

}
