package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pojos.User;
import static utils.DBUtils.fetchDBConnection;

public class UserDaoImpl implements IUserDao 
{
	
	private Connection cn;
    private PreparedStatement pst1;
    
      public UserDaoImpl() throws ClassNotFoundException,SQLException 
      {
		super();
		cn = fetchDBConnection();
		pst1 = cn.prepareStatement("Select * from users where email = ? and password = ?");
		System.out.println("user dao created");
		
	   }

	@Override
	public User validateUser(String email, String pwd) throws SQLException 
	{
	    pst1.setString(1,email);
	    pst1.setString(2,pwd);
	    try(ResultSet rst = pst1.executeQuery())
	    {
	    	if(rst.next())
	    	{
	    		return new User(rst.getInt(1), rst.getString(2),email,pwd,rst.getDouble(5),rst.getDate(6),rst.getString(7));
	    	}
	    }
		return null;
	}
	
	public void cleanUp() throws SQLException
	{
		if(pst1 != null)
		{
			pst1.close();
		}
		System.out.println("user dao cleaned up!");
	}

}
