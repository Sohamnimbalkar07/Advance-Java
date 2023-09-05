package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	/**
	 * @see Servlet#init()
	 */
	public void init() throws ServletException {
		try
		{
		//dao inst
		userDao = new UserDaoImpl();
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
		System.out.println("in do-post of " + getClass().getName());
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
	    	pw.print("<h5> LOgin successfully from login page</h5>" );//appear
	    	//save validated user details under min suitable scope (request) : used in server pull
	    	request.setAttribute("user_dtls", user);
	    	//RD steps
	    	//1. get RD object from WC
	    	RequestDispatcher rd = request.getRequestDispatcher("topics");
	    	//forward clnt to next page in SAME request
	    	rd.include(request, response);
	    	//WC : suspends exec of this method.invokes Topicservlets buffer
	    	//control comes back to login servlets n continues....
	    	System.out.println("control back in login servlet....");
	    	}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ServletException("error i do-post of"+ getClass().getName(),e);
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
