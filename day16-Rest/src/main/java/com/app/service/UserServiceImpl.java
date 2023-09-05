package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.UserHandlingException;
import com.app.dao.UserRepository;
import com.app.pojos.User;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private UserRepository userRepo;
	@Override
	public List<User> getAllUsers() {
		
		
		return userRepo.findAll();
	}

	@Override
	public User updateDetails(User detachedUser) {
		return userRepo.save(detachedUser);
		
	}

	@Override
	public String deleteUser(int userId) {
		userRepo.deleteById(userId);
		return "UserDetails deleted";
	}

	
	
	@Override
	public User addUser(User user) 
	{
		return userRepo.save(user);
	}//when method annotated with @Transactional returns : JPA provider(currently Hibernate) will end transaction.
     //it will automatically commit transaction : in case of no runtimeException or in case of exc : automatically rollback happens
	
	public User getDetails(int userId)
	{
		return userRepo.findById(userId).
		    orElseThrow(() -> new UserHandlingException("invalid USer id"));
	}
	
	
}
