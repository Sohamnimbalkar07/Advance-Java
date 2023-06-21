package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TopicsServlets
 */
@WebServlet("/topics")
public class TopicsServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         
		response.setContentType("text/html");
		try(PrintWriter pw = response.getWriter())
		{
			pw.print("<h5> Login Successful from topic servlet....</h5>");
			
			//get validate user details from cookie
			//API : Method HttpServletRequest
			//Cookie[] getCookies() : null=> no cookies
			//not null --- cookies exist --- iterate over the array ---look for the cookies holding the user details
			//send it's value in the response
			Cookie[] cookies = request.getCookies();
			if(cookies != null)
			{
				for (Cookie c : cookies)
				{
					if(c.getName().equals("validated_user_dtls"))
					{
						pw.print("<h5> User Details fetched from a cookie" + c.getValue()+ "</h5>");
					}
				}
			}
			else  // no cookies
			{
				pw.print("<h5> No cookies : session tracking failed !!!!!</h5>");
			}
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
