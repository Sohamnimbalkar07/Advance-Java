package dependent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;


import dependency.Transport;

@Component("my_atm")
public class ATMImpl implements ATM {
	@Autowired
	@Qualifier("httpTransport")
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
	
	//@PostConstruct
	public void myInit()
	{
		System.out.println("in init" + myTransport);
	}
	
	//@PreDestroy
	public void myDestroy()
	{
		System.out.println("in Destroy" + myTransport);
	}
	

}
