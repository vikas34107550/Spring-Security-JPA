package com.security.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.api.model.User;

public interface UserRepositry extends JpaRepository<User, Integer>{
	
	User findByuserName(String userName);

}
