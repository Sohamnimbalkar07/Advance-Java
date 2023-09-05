package dependent;

import dependency.Transport;

public class ATMImpl implements ATM {
	private Transport myTransport;//=new HttpTransport();// dependency

	//constr based D.I
	private ATMImpl() {
        
		System.out.println("in cnstr of ATMImpl " + getClass().getName() + " " + myTransport);
	}

//B.L methods
	@Override
	public void deposit(double amt) {
		System.out.println("depositing " + amt);
		byte[] data = ("depositing " + amt).getBytes();
		myTransport.informBank(data);// dependent obj(ATMImpl) invoking a method of dependency (transport layer) to
										// inform underlying bank

	}

	@Override
	public void withdraw(double amt) {
		System.out.println("withdrawing " + amt);
		byte[] data = ("withdrawing " + amt).getBytes();
		myTransport.informBank(data);
	}
	
	public void myInit()
	{
		System.out.println("in init" + myTransport);
	}
	
	public static ATMImpl myFactory(Transport t)
	{
		System.out.println("in factory method");
		ATMImpl atm = new ATMImpl();
		atm.myTransport =t;
		return atm;
	}

}
