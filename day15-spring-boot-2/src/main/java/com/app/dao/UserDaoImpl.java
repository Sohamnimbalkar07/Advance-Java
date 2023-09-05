package com.app.dao;


import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUserDao;
import com.app.pojos.User;

@Repository

public class UserDaoImpl implements IUserDao 
{
	@Autowired // bytype
	private EntityManager manager ;
	
	public UserDaoImpl()
	{
		System.out.println("in user dao constructor");
	}
	
	@Override
	public User validateUser(String email, String pass) {
		
		String jpql= "select u from User where u.email=:em and u.password=:pass";
		
		return manager.createQuery(jpql,User.class).setParameter("em",email).setParameter("pass",pass).getSingleResult();
		
	}

}
