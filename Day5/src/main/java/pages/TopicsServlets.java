package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TopicDaoImpl;
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         
		response.setContentType("text/html");
		try(PrintWriter pw = response.getWriter())
		{
			pw.print("<h5> Login Successful from topic servlet....</h5>");
			//get validated user details from a httpSession
			//1. get HttpSession from WC
			HttpSession hs = request.getSession();//rets Existing HS object to the caller
			System.out.println("from topics page" + hs.isNew());//false
	    	System.out.println("Session ID" + hs.getId());//same for same client
	    	//get validated user details from HttpSession
	    	User user = (User)hs.getAttribute("user_details");
			if(user != null)//session tracking : works!
			{
				pw.print("<h5> Validated USer Details from session" + user+"</h5");
				pw.print("</br>");
				pw.print("</br>");
				TopicDaoImpl dao = (TopicDaoImpl)hs.getAttribute("topic_dao");
				//invoke topic dao's method to get all topic names
				List<String>allTopicNames = dao.getAllTopicNames();
				//allTopicNames.forEach(topicName -> pw.print(topicName + "</br>"));
				//dynamic form generation
				pw.print("<form action='tutorials'>");
				// <input type='radio' name='topic_id' value='actual topic id '/>lable : topic name
				allTopicNames.forEach(topicName -> pw
						.print("<input type='radio' name='topic' value='" + topicName + "'/>"
							+ topicName + "<br/>"));
				pw.print("<input type='submit' value='Choose Topic'/>");
				pw.print("</form>");
			}
			else  // no cookies
			{
				pw.print("<h5> No cookies : session tracking failed !!!!!</h5>");
			}
			pw.print("<h5> <a href='logout'> Log Out </a> </h5>");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ServletException("err in do_get of" + getClass().getName(),e);
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
