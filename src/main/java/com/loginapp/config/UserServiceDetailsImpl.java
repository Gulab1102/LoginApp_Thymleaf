package com.loginapp.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.loginapp.model.User;
import com.loginapp.service.UserServiceImpl;

public class UserServiceDetailsImpl implements UserDetailsService {
	
	@Autowired
	private UserServiceImpl userServiceImpl;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		//return userServiceImpl.getUserByUserName(username);
		
		//User user=userServiceImpl.getUserByUserName(username);;
		
		User user=userServiceImpl.getUserByUserName(username);
		
		if(user!=null) {
			return new CustomUserDetail(user);
		}
		
		throw new UsernameNotFoundException("User Not Availabe");
	}

}
