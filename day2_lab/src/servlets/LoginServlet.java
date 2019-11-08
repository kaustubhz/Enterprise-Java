package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.VotingDaoImpl;
import pojos.Voter;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		System.out.println("In init "+Thread.currentThread());
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("In destroy "+Thread.currentThread());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");	
		try (PrintWriter pw=response.getWriter()){
				VotingDaoImpl dao1=new VotingDaoImpl();
				Voter objVoter=dao1.authenticateVoter(request.getParameter("email"), request.getParameter("pass"));
				if(objVoter!=null)
				{
					pw.print("<h2 align=center>Hello ");
					pw.print(objVoter.getEmail()+"</h2>");
				}
				else
				{
					pw.print("Invalid login credentials");
					Thread.sleep(5000);
					response.sendRedirect("/day2_lab");				
				}
			} catch (Exception e) {
				throw new ServletException("Something went wrong in doget",e);
			} 
	}

}
