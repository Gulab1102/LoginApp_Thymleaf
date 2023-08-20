package com.loginapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loginapp.model.User;
import com.loginapp.repository.UserRepository;

@Service

public class UserServiceImpl implements UserService {
	  @Autowired
		private UserRepository userRepository;

		@Override
		public User createUser(User user) {
			// TODO Auto-generated method stub
			return userRepository.save(user);
		}

		@Override
		public boolean checkEmail(String email) {
			// TODO Auto-generated method stub
			
			return userRepository.existsByEmail(email);
		}

}
