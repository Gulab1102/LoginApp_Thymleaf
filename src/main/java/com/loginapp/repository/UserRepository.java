package com.loginapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loginapp.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
