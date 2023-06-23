package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojos.User;

/**
 * Servlet implementation class TopicsServlets
 */
@WebServlet("/topics")
public class TopicsServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         
		System.out.println("in do-post of " + getClass().getName());
		response.setContentType("text/html");
		try(PrintWriter pw = response.getWriter())
		{
			pw.print("<h5> Login Successful from topic servlet....</h5>");
			//how to retrive the user details? : from the request scope
			User user = (User) request.getAttribute("user_dtls");
			if(user != null)
			{
				pw.print("<h5> USer details fetched from current request scope" + user+"</h5");
			}
			else
			{
				pw.print("<h5>  Request dispatching failed !!</h5");
			}
			
		}
		
	}

}
