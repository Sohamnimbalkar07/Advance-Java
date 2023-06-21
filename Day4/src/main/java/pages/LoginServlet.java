package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

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
	    	    //create cookie : using validated user details
	    	    //javax.servlet.http.cookie(String cookieName,String cookieValue)
	    	Cookie c1 = new Cookie("validated_user_dtls",user.toString());
	    	
	    	//send cookie to the client(in response header)
	    	//method of HttpServletResponse
	    	//public void addCookie(Cookie c)
	    	response.addCookie(c1);
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
