package dao;

import pojos.User;

public interface IUserDao {

	String saveUser(User user);
	public User getUserDetails(int userId);
}
