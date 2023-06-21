package utils;

import java.sql.*;

public class DBUtils {
	
	private static Connection connection;
	//add static method to return singleton connection instance 
	public static Connection fetchDBConnection() throws ClassNotFoundException,SQLException
    {    
		if(connection == null)
		{
		//load JDBC driver in to the method area of JVM
		Class.forName("com.mysql.cj.jdbc.Driver");
		//establish connection with DB
		String url = "jdbc:mysql://localhost:3306/iacsd?useSSL=false&allowPublicKeyRetrieval=true";
		connection = DriverManager.getConnection(url,"root","welcome");
		}
		return connection;
	}
}
