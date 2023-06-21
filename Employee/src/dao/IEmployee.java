package dao;

import java.sql.SQLException;
import pojos.Employee;
import java.util.List;

public interface IEmployee {

	public List<Employee> getSelectedEmpDetails(String deptId,String beginDate,String endDate) throws SQLException;

	String addEmpDetails(Employee emp) throws SQLException;
	
	String updateEmpDetails(int empID,String newDept,double salIncrement) throws SQLException;
}
