package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static utils.DBUtils.fetchDBConnection;

import pojos.Employee;

public class EmployeeDaoImpl implements IEmployee { 

	private static final List<Employee> list = null;
	private Connection cn;
	private PreparedStatement pst1;
	private PreparedStatement pst2,pst3;
	
	public EmployeeDaoImpl() throws ClassNotFoundException, SQLException
	{
		cn = fetchDBConnection();
		String sql = "select empid,name,salary,join_date from my_emp where deptid= ? and join_date between ? and ?";
		pst1 = cn.prepareStatement(sql);
		
		pst2 = cn.prepareStatement("insert into my_emp values(default,?,?,?,?,?)");
		
		pst3 = cn.prepareStatement("update my_emp set deptid=?,salary= salary + ? where empid=?");
		System.out.println("emp dao created....");
	}
	@Override
	public List<Employee> getSelectedEmpDetails(String deptId, String beginDate, String endDate) throws SQLException  
	{
		
		List<Employee> list = new ArrayList<>();
		pst1.setString(1, deptId);
		pst1.setDate(2, Date.valueOf(beginDate));
		pst1.setDate(3, Date.valueOf(endDate));
		
		try(ResultSet rst = pst1.executeQuery())
		{
			while(rst.next())
			{
				list.add(new Employee(rst.getInt(1), rst.getString(2),rst.getDouble(3),rst.getDate(4)));
			}
		}
		
		return list;
	}
	
	public void CleanUp() throws SQLException
	{
		if(pst1 != null)
		{
			pst1.close();
		}
		if(pst2 !=null)
		{
			pst2.close();
		}
		
		if(pst3 !=null)
		{
			pst3.close();
		}
		if(cn != null)
		{
			cn.close();
		}
		System.out.println("emp dao cleaned up!");
	}
	@Override
	public String addEmpDetails(Employee emp) throws SQLException {
		pst2.setString(1,emp.getName());
		pst2.setString(2,emp.getAddress());
		pst2.setDouble(3,emp.getSalary());
		pst2.setString(4,emp.getDeptID());
		pst2.setDate(5,emp.getJoinDate());
		
		int updateCount = pst2.executeUpdate();
		if(updateCount == 1)
		{
			return "Emp details inserted...";
		}
		return "Inserting emp details failed...";
	}
	@Override
	public String updateEmpDetails(int empID, String newDept, double salIncrement) throws SQLException {
		pst3.setString(1, newDept);
		pst3.setDouble(2,salIncrement);
		pst3.setInt(3,empID);
		int updateCount = pst3.executeUpdate();
		if(updateCount== 1)
		{
			return "Emp details updated....";
		}
		return "Updating emp details failed!!!";
	}

}
