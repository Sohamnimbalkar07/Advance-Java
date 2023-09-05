package com.app;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.dao.UserRepository;
import com.app.pojos.User;
import com.app.service.IUserService;

@SpringBootTest
class Day16RestApplicationTests {

	@Autowired
	private IUserService userService;
	@Autowired
	private UserRepository userRepo;
	
	@Test
	void contextLoads() {
		List<User> allUsers = userService.getAllUsers();
		assertEquals(0,allUsers.size());
	}
	
	public void testSaveUser() throws Exception
	{
		User user = new User("kiran","khare", "mihir",23, 12345);
		User persistentUser = userRepo.save(user);
		assertEquals(1,persistentUser.getId());
	}

	
}
