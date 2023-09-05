package tester;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import config.SpringAppConfig;
import dependent.ATMImpl;

public class TestSpring {

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringAppConfig.class)) {
			System.out.println("SC up n running");
			//get ready to use spring bean to invoke B.L
			ATMImpl atm1=ctx.getBean("my_atm", ATMImpl.class);//clnt making the demand for the bean
			//invoke B.L 
			atm1.deposit(2000);
			ATMImpl atm2=ctx.getBean("my_atm", ATMImpl.class);//clnt making the demand for the bean
			System.out.println(atm1==atm2);//false
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
