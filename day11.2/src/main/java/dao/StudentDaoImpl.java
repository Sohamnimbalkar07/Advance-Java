package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import static utils.HibernateUtils.getFactory;

import pojos.Address;
import pojos.Course;
import pojos.Student;

public class StudentDaoImpl implements IStudentDao {

//	@Override
//	public String linkAddressDetails(long studentId, Address a) {
//		String mesg = "linking address failed";
//		// get Session from SF
//		Session session = getFactory().getCurrentSession();
//		// begin tx
//		Transaction tx = session.beginTransaction();
//		try {
//			// get student details
//			Student s = session.get(Student.class, studentId);
//			if (s != null) {
//				s.setAddress(a);// student ---> adr
//				a.setStudent(s);// adr --> student
//				// s : persistent
//				session.persist(a);
//				mesg = "address linked ...";
//			}
//			tx.commit();
//
//		} catch (RuntimeException e) {
//			if (tx != null)
//				tx.rollback();
//			throw e;
//		}
//		return mesg;
//	}

	@Override
	public String admitNewStudent(Student student, String courseTitle) {
		String mesg = "student admission failed";
		String jpql = "select c from Course c where c.title=:title";
		// get Session from SF
		Session session = getFactory().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			Course course = session.createQuery(jpql, Course.class).setParameter("title", courseTitle).getSingleResult();
			student.setCourseEnrolled(course);
			session.persist(student);
			tx.commit();
			mesg = "admitted successfully!!!";
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

}
