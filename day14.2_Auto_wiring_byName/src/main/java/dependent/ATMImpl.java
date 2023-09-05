package dependent;

import dependency.Transport;

public class ATMImpl implements ATM {
	private Transport myTransport;//=new HttpTransport();// dependency

	//constr based D.I
	public ATMImpl() {
//		myTransport=t;
		System.out.println("in cnstr of " + getClass().getName() + " " + myTransport);
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
	//setter Based D.I (dependency injection)
	public void setMyTransport(Transport myTransport) {
		System.out.println("in set transport");
		this.myTransport = myTransport;
	}
	
	public void myInit()
	{
		System.out.println("in init" + myTransport);
	}
	
	public void myDestroy()
	{
		System.out.println("in Destroy" + myTransport);
	}
	

}
