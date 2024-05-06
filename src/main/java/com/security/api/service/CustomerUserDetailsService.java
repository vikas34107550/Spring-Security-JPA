package com.security.api.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import com.security.api.model.User;

import com.security.api.Repository.UserRepositry;
 
public class CustomerUserDetailsService implements UserDetailsService {
 
    @Autowired
    private UserRepositry userRepository;
     
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
         User user = userRepository.findByuserName(username);
         
        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
         
        return new CustomerUserDetails(user);
    }
 
}