package com.security.api.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.api.Repository.UserRepositry;
import com.security.api.model.User;

@RequestMapping("/user")
@RestController
public class UserController {

	@Autowired
	UserRepositry userRepositry;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

		
	@PreAuthorize("hasAnyRole('USER')")
	@GetMapping("/edit")
	public String getReadByUser() {
		return "Read by User";
	}


	
	
}
