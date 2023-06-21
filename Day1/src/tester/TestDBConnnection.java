package tester;

import java.sql.Connection;

import utils.DBUtils;

public class TestDBConnnection {

	public static void main(String[] args) {
		
		try(Connection cn = DBUtils.fetchDBConnection())
		{
			System.out.println("connected to DB" + cn);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
