package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TutorialDaoImpl;

/**
 * Servlet implementation class TutorialsServlet
 */
@WebServlet("/tutorials")
public class TutorialsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try(PrintWriter pw = response.getWriter())
		{
			//get session
			HttpSession session = request.getSession();
			//get tut dao instance from the session
			TutorialDaoImpl tutDao = (TutorialDaoImpl) session.getAttribute("tut_dao");
			if(tutDao != null)
			{
				String topicName = request.getParameter("topic");
				pw.print("<h4> All Tutorials under Topic :" + topicName+ "</h4>");
				List<String> allTutorialByTopic = tutDao.getAllTutorialByTopic(topicName);
				allTutorialByTopic.forEach(tutName -> pw.print("<a href='tutorial_details?name="+tutName+"'>"+tutName+ "</a><br/>"));
			}
			else  // no cookies
			{
				pw.print("<h5> No cookies : session tracking failed !!!!!</h5>");
			}
		} catch (Exception e) {
			
			throw new ServletException("err in do_get of" + getClass().getName(),e);
		}
	}

}
