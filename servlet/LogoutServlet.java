package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public LogoutServlet()
	{
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		request.getRequestDispatcher("index.html").include(request, response);
		HttpSession session = request.getSession();
		if(session.getAttribute("name") != null)
		{
			session.invalidate();
			out.print("<center>");
			out.print("<h2> You are successfully logged out!</h2>");
			out.print("</center>");
		}
		else
		{
			out.print("<center>");
			out.print("<h2>You aren't logged in!</h2>");
			out.print("</center>");
		}
		out.close();
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request,response);
	}
}
