package beans;

import java.sql.SQLException;

import dao.UserDaoImpl;
import pojos.User;

public class UserBean {

	//properties : state(non static, no transient data members)
	//client conversational state
	private String email;
	private String password;
	//DAO layer ref
	private UserDaoImpl userDao;
	//validated user details
	private User validatedUserDetails;
	//status message
	private String message;
	//default arg-less constr
	public UserBean() throws ClassNotFoundException,SQLException {
		super();
		System.out.println("in user beam constr");
		//create instance of DAO
		userDao= new UserDaoImpl();
	}

	//setters and getters
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserDaoImpl getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDaoImpl userDao) {
		this.userDao = userDao;
	}

	public User getValidatedUserDetails() {
		return validatedUserDetails;
	}

	public void setValidatedUserDetails(User validatedUserDetails) {
		this.validatedUserDetails = validatedUserDetails;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	//add B.L method : for user validation
	public String authenticateUser() throws SQLException
	{
		System.out.println("in B.L auth" + email + " "+ password );
		//invoke Dao's method for validation
	validatedUserDetails=userDao.validateUser(email, password);
	//null checking
	System.out.println(validatedUserDetails);
	if(validatedUserDetails == null)
	{   message ="Invalid Login , please retry....";
		return "login";
	}
	//=> valid login
	//role bases authorization
	if(validatedUserDetails.getRole().equals("CUSTOMER"))//customer login
    {   message="Customer login successful!!!";
		return "topics";
	}
	//admin login
	message="admin login successful!!!";
		return "show_tut_form";
	}
	
}
