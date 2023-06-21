package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import pojos.Employee;
import static utils.DBUtils.fetchDBConnection;

public class BankAccountDaoImpl implements IBankAccountDao {

	private Connection cn;
	private CallableStatement cst1;
	
	public BankAccountDaoImpl() throws ClassNotFoundException,SQLException 
	{
		cn = fetchDBConnection();
		String invocationSyntax = "{call transfer_funds(?,?,?,?,?)}";
		cst1 = cn.prepareCall(invocationSyntax);
		cst1.registerOutParameter(4, Types.DOUBLE);
		cst1.registerOutParameter(5, Types.DOUBLE);

	}
     
	
    public String transferFunds(int srcId, int destId, double amount) throws SQLException 
    {
		cst1.setInt(1, srcId);
		cst1.setInt(2, destId);
		cst1.setDouble(3, amount);
		cst1.execute();
		StringBuilder sb = new StringBuilder("Funds transferred!");
		sb.append("updated src balance" + cst1.getDouble(4));
		sb.append("Updated dest balance" + cst1.getDouble(5));
		return sb.toString();
	}

	public void cleanUp() throws SQLException
	{
		if(cst1 != null)
		{
			cst1.close();
		}
		if(cn != null)
		{
			cn.close();
		}
		System.out.println("acct dao cleaned up!!");
	}

}
