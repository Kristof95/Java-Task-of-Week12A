package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet
{
	private String defaultPw = "admin";
	private String defaultUsr = "admin";
	private HttpSession session;
	
	private static final long serialVersionUID = 1L;

	public LoginServlet()
	{
		super();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("index.html").include(request, response);
		
		String name = request.getParameter("name");
		String password = request.getParameter("psw");
		session = request.getSession();
		
		if(!name.equals(session.getAttribute("name")))
		{
			if(name.equals(defaultUsr) && password.equals(defaultPw))
			{
				request.getRequestDispatcher("welcome.html").include(request, response);
				out.print("<center>");
				out.print("<h2>Welcome, "+name + " have a nice day!</h2>");
				out.print("</center>");
				session.setAttribute("name",name);
			}
			else
			{
				out.print("<center>");
				out.print("<h2>Bad username or password! Permission denied!</h2>");
				out.print("</center>");
//				request.getRequestDispatcher("login.html").include(request, response);
			}
		}
		else
		{
			out.print("<center>");
			out.print("<h2>You already logged in!</h2>");
			out.print("</center>");
//			request.getRequestDispatcher("index.html").include(request, response);
		}
		out.close();
	}
}
