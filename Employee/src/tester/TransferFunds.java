package tester;
import java.util.Scanner;
import dao.BankAccountDaoImpl;

public class TransferFunds {

	public static void main(String[] args)
	{
	try(Scanner sc = new Scanner(System.in))
	{
		BankAccountDaoImpl acctDao = new BankAccountDaoImpl();
		System.out.println("Enter src n dest nos n transferAmount");
		String mesg = acctDao.transferFunds(sc.nextInt(), sc.nextInt(), sc.nextDouble());
		System.out.println(mesg);
		acctDao.cleanUp();
		
		}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	}
}
