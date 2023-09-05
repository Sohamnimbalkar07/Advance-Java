package dao;

import pojos.Role;
import pojos.User;
import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.*;

public class UserDaoImpl implements IUserDao {

	@Override
	public String saveUser(User user) {
		// get hibernate session from SF using openSession API
		Session session = getFactory().openSession(); // L1 cache created along with hib session n db conn pooled out
		Session session2 = getFactory().openSession();
		System.out.println("same sessions? " + (session == session2));// f
		// begin hibernate transaction(tx)
		Transaction tx = session.beginTransaction();
		System.out.println("is open " + session.isOpen() + " is connected " + session.isConnected());// t t
		try {
			// Session API : public Serializable save(Object entity)
			session.save(user);
			// => success --commit
			tx.commit();// hib fires insert query (DML)
			System.out.println("is open " + session.isOpen() + " is connected " + session.isConnected());// t t

		} catch (RuntimeException e) {
			// failure -- rollback
			if (tx != null)
				tx.rollback();
			throw e;// re throwing SAME exc to the caller for info.
		} finally {
			if (session != null)
				session.close();// L1 cache is destroyed n pooled out db cn , rets to the pool
		}
		System.out.println("is open " + session.isOpen() + " is connected " + session.isConnected());// f f

		return "User details inserted with user ID " + user.getUserId();
	}
	
	public User getUserDetails(int userId) {
		User user = null;// user : does not exist!
		// get Session from SF
		Session session = getFactory().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			// API of Session : public <T> T get(Class<T> cls, Serializable id) throws
			// HibernateExc
			user = session.get(User.class, userId);// in case of valid id --user : PERSISTENT , has a corresponding rec
													// in DB n it's part of L1 cache

			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return user;
	}
}
