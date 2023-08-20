package com.loginapp.service;

import com.loginapp.model.User;

public interface UserService {
	
public User createUser(User user);
	
	public boolean checkEmail(String email);

}
