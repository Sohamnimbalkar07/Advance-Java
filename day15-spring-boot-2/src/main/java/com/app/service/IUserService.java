package com.app.service;

import com.app.pojos.User;

public interface IUserService {

	public User validateUser(String email, String pass);
}
