package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Course;
import static utils.HibernateUtils.getFactory;

public class CourseDaoImpl implements ICourseDao {

	@Override
	public String launchNewCourse(Course course) {
		String mesg="Course launchin failed!!!!!!";
		// get Session from SF
		Session session = getFactory().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			session.persist(course);
			tx.commit();
			mesg="A New Course launched with ID="+course.getId();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

}
