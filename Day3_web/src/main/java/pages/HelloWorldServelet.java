package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//trace life cycle of servlet managed by web container
@WebServlet(urlPatterns = "/hello")
//web container :Map
//key : /hello
//value : F.Q servlet class name (pages.HelloWorldServlet)
public class HelloWorldServelet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
     //override init method

	@Override
	public void init() throws ServletException {
		
		super.init();
		System.out.println("in init : invoked by" + Thread.currentThread());
	}

	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("in do-get : invoked by" + Thread.currentThread());
		//objective : send dyn resp to the clnt
		//1.set resp content type(resp header) : text/html
		resp.setContentType("text/html");
		//2.attach buffered, char o/p stream to send resp from servlet ---> web clnt
		try(PrintWriter pw = resp.getWriter())
		{
			pw.print("<h5>Welcome to servlets..."+LocalDateTime.now()+" </h5>");		
		}
		super.doGet(req, resp);
	}



	@Override
	public void destroy() {
	    super.destroy();
	    System.out.println("in destroy : invoked by" + Thread.currentThread());
	}
	
	
}
