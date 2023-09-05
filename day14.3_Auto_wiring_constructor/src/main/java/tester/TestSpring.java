package tester;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import dependent.ATMImpl;

public class TestSpring {

	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("springconfig.xml")) {
			System.out.println("SC up n running");
			//get ready to use spring bean to invoke B.L
			ATMImpl atm1=ctx.getBean("my_atm", ATMImpl.class);//clnt making the demand for the bean
			//invoke B.L 
			atm1.deposit(1000);
			ATMImpl atm2=ctx.getBean("my_atm", ATMImpl.class);//clnt making the demand for the bean
			System.out.println(atm1==atm2);//false
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
