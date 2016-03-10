package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public ProfileServlet()
	{
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("index.html").include(request, response);
		
		HttpSession session = request.getSession(false);
		if(session != null)
		{
			String name = (String) session.getAttribute("name");
			if(name != null)
			{				
				out.print("<center>");
				out.print("<h2> Hy, "+name+" Welcome to Profile!</h2>");
				out.print("</center>");
			}
			else
			{
				out.print("<center>");
				out.print("<h2>Please login first!</h2>");
				out.print("</center>");
//				request.getRequestDispatcher("login.html").include(request,response);
//				response.sendRedirect("login.html");
			}
		}
		else
		{
//			response.sendRedirect("login.html");
			out.print("<center>");
			out.print("<h2>Please login first!</h2>");
			out.print("</center>");
		}
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
