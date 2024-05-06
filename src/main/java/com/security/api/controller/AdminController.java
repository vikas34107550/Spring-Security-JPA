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

@RequestMapping("/admin")
@RestController
public class AdminController {

	@Autowired
	UserRepositry userRepositry;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	// @PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping("/add")
	public String addUserByAdmin(@RequestBody User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepositry.save(user);
		Collection<? extends GrantedAuthority> listroles = SecurityContextHolder.getContext().getAuthentication()
				.getAuthorities();
		Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) SecurityContextHolder
				.getContext().getAuthentication().getAuthorities();

		for (GrantedAuthority a : listroles) {
			System.out.println(a.toString());
			System.out.println(a.getAuthority().toString());

		}
		System.out.println(authorities);
		return "User Added Successfully";

	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/getMsg")
	public String getMsg() {
		Collection<? extends GrantedAuthority> listroles = SecurityContextHolder.getContext().getAuthentication()
				.getAuthorities();
		Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) SecurityContextHolder
				.getContext().getAuthentication().getAuthorities();

		for (GrantedAuthority a : listroles) {
			System.out.println(a.toString());
			System.out.println(a.getAuthority().toString());

		}
		System.out.println(authorities);
		return "helllo admin";

	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/delete")
	public String getDeleteByAdmin() {
		return "delete by only admin";
	}


	
	
}
