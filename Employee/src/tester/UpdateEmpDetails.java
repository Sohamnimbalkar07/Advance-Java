package tester;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

import dao.EmployeeDaoImpl;
import pojos.Employee;
public class UpdateEmpDetails {

	public static void main(String[] args) {
		
		try(Scanner sc = new Scanner(System.in))
		{
			EmployeeDaoImpl empDao = new EmployeeDaoImpl();		
			System.out.println("Enter empid new dept n sal increment");
			String message = empDao.updateEmpDetails(sc.nextInt(),sc.next(),sc.nextDouble());
			System.out.println("emp insertion status mesg" + message);
			empDao.CleanUp();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
