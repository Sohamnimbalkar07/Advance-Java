package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TopicDaoImpl;
import dao.TutorialDaoImpl;
import dao.UserDaoImpl;
import pojos.User;
import utils.DBUtils;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(value= "/validate", loadOnStartup = 1)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl userDao;
    private TopicDaoImpl topicDao;
    private TutorialDaoImpl tutDao;
	/**
	 * @see Servlet#init()
	 */
	public void init() throws ServletException {
		try
		{
		//dao inst
		userDao = new UserDaoImpl();
		topicDao = new TopicDaoImpl();
		tutDao= new TutorialDaoImpl();
		}catch(Exception e)
		{   //to inform web container that init() has failed -- so don't continue with servicing : throw servletExc
			throw new ServletException("err in init of" + getClass().getName(),e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			userDao.cleanUp();
			topicDao.cleanUp();
			tutDao.cleanUp();
			DBUtils.closeConnectio();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		  System.out.println("err in destroy of" + getClass().getName()+ " " +e);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1: set content type
		response.setContentType("text/html");
		try(PrintWriter pw = response.getWriter())
		{   //read request para send by client
			String email = request.getParameter("em");
		    String password = request.getParameter("pass");
		    //invoke dao's method for user validation
		    User user = userDao.validateUser(email,password);
		    if(user == null)
		    {
		    	pw.print("<h5>Invalid login,Please <a href = 'login.html' > Retry </a></h5>");
		    }
		    else
		    {
		    	//send in resp : valiadte user details
//		    	pw.print("<h5> Login successful!!! </h5>" );
	    	pw.print("<h5> Validated user Details :"+ user+" </h5>" );
	    	   
	    	  //1. request web container to get session
	    	HttpSession session = request.getSession();
	    	System.out.println("Session : " + session.getClass().getName());
	    	System.out.println("from login page" + session.isNew());//true
	    	System.out.println("Session ID" + session.getId());
	    	//add validated user details under session scope
	    	session.setAttribute("user_details",user);
	    	//add topic dao instance under session scope (so that other servlets can share the same)
	    	session.setAttribute("topic_dao", topicDao);
	    	//add tut dao instance under session scope (so that other servlets can share the same)
	    	session.setAttribute("tut_dao", tutDao);
		    	//in case of successful login : redirect to topics page
		    	//API : HttpServletResponse
		    	//public void sendRedirect(String location) throws IOException
		    	response.sendRedirect("topics");//programmer
		    	//web container : sends temp redirect resp to the clnt
		    	//status : SC302 | location=topics, content-length=0, set cookie : validated_user_dtls : tostring of user | body = EMPTY
		    	//client browser : generate a NEW request
		    	//URL : http://host:port/day4.1/topics, method= GET
		    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ServletException("error i do-post of"+ getClass().getName(),e);
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
