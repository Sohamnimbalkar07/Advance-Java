package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.CourseDaoImpl;
import pojos.Course;
import static java.time.LocalDate.parse;

public class LaunchNewCourse {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			CourseDaoImpl courseDao=new CourseDaoImpl();
			System.out.println("Enter course details : title,  startDate,  endDate,  fees,  capacity");
			Course c = new Course(sc.next(), parse(sc.next()), parse(sc.next()), sc.nextDouble(), sc.nextInt());
			System.out.println(courseDao.launchNewCourse(c));
		} // sf.close() => immediate closing of cn pool
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
