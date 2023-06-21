package tester;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

import dao.EmployeeDaoImpl;
import pojos.Employee;
public class InsertEmpDetails {

	public static void main(String[] args) {
		
		try(Scanner sc = new Scanner(System.in))
		{
			EmployeeDaoImpl empDao = new EmployeeDaoImpl();		
			System.out.println("Enter emp datails : name, address,salary, deptId,joinDate(yyyy-m-d)");
			String message = empDao.addEmpDetails(new Employee(sc.next(),sc.next(),sc.nextDouble(),sc.next(),Date.valueOf(sc.next())));
			System.out.println("emp insertion status mesg" + message);
			empDao.CleanUp();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
