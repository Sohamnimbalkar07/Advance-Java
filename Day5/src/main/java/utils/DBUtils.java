package utils;

import java.sql.*;
public class DBUtils {

	public static Connection connection;
	
	public static Connection fetchDBConnection() throws ClassNotFoundException,SQLException
	{
		if(connection == null)
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/iacsd?useSSL=false&allowPublicKeyRetrieval=true";
			connection = DriverManager.getConnection(url,"root","welcome");
			
		}
		return connection;
	}
	
	//add a static method to close database connection
	public static void closeConnectio() throws SQLException
	{
		if(connection != null)
		{
			connection.close();
		}
	}
}
