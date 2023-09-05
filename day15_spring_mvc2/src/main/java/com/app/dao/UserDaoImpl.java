package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.IUserDao;
import com.app.pojos.User;

@Repository
public class UserDaoImpl implements IUserDao 
{
	@Autowired // bytype
	private SessionFactory sf;
	
	@Override
	public User validateUser(String email, String pass) {
		
		String jpql= "select u from User where u.email=:em and u.password=:pass";
		
		return sf.getCurrentSession().createQuery(jpql,User.class).setParameter("em",email).setParameter("pass",pass).getSingleResult();
		
	}

}
