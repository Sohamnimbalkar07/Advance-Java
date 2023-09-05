package tester;

import static java.time.LocalDate.parse;
import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.CourseDaoImpl;
import dao.StudentDaoImpl;
import pojos.Course;
import pojos.Student;

public class StudentAdmission {

	public static void main(String[] args) {
	
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter Student Details: name email");
			Student student = new Student(sc.next(),sc.next());
			System.out.println("enter course title");
			StudentDaoImpl dao = new StudentDaoImpl();
			System.out.println(dao.admitNewStudent(student,sc.next()));
		} // sf.close() => immediate closing of cn pool
		catch (Exception e) {
			e.printStackTrace();
		}

	}

	

}
