package tester;

import dependency.HttpTransport;
import dependent.ATMImpl;

public class TestATM {

	public static void main(String[] args) {
		//creating a dependent obj 
		ATMImpl atm=new ATMImpl();
		//creating dependency obj
		HttpTransport transport=new HttpTransport();
		//link / wire /connect : D.I : prog
		atm.setMyTransport(transport);
		
		atm.deposit(1000);

	}

}
