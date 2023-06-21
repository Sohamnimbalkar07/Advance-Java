package tester;

import java.sql.SQLException;
import java.util.Scanner;
import dao.EmployeeDaoImpl;
import pojos.Employee;
import java.util.List;
public class GetEmpDetails {

	public static void main(String[] args)   {
		
		try(Scanner sc = new Scanner(System.in))
		{
			EmployeeDaoImpl empDao = new EmployeeDaoImpl();
			System.out.println("Enter dept id,start date and end date");
			List<Employee> empList = empDao.getSelectedEmpDetails(sc.next(),sc.next(),sc.next());
			System.out.println("Emps List");
			empList.forEach(System.out::println);
			empDao.CleanUp();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
