package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.VotingDaoImpl;
import pojos.Voter;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VotingDaoImpl dao1;
	public HttpSession hs;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		System.out.println("In login init "+Thread.currentThread());
		try{
			dao1=new VotingDaoImpl();
		}catch (Exception e) {
			throw new ServletException("Something went wrong in doInit()",e);
		} 
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("In login destroy "+Thread.currentThread());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");	
		try (PrintWriter pw=response.getWriter()){	
			
			hs=request.getSession();
				if(request.getParameter("email").equals("admin@gmail.com") && request.getParameter("pass").equals("admin"))	
				{
					hs.setAttribute("super","admin" );
					response.sendRedirect("alldetails");
				}
				Voter objVoter=dao1.authenticateVoter(request.getParameter("email"), request.getParameter("pass"));
				if(objVoter!=null)
				{
					
					hs.setAttribute("voter",objVoter);
					pw.print("<h2 align=center>Hello ");					
					pw.print(objVoter.getEmail()+"</h2>");
					if(objVoter.getStatus().equals("YES"))
						pw.print("<h3 align=center>You have already voted</h3>");
					else
					{
//						pw.print("<h3 align=center>You have not voted</h3>");
						response.sendRedirect("candidatelist");
					}	
				}
				else
				{
					pw.print("<h2>Invalid login credentials</h2>");
					//Thread.sleep(5000);
//				response.sendRedirect("/day2_lab");				
				}
			} catch (Exception e) {
				throw new ServletException("Something went wrong in doGet()",e);
			} 
	}

}
