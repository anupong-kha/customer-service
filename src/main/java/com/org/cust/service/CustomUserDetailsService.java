package com.org.cust.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Example user (replace with database logic)
        if ("user".equals(username)) {
            return new User("user", "{noop}password", Collections.emptyList()); // Use {noop} for plain text password for testing
        }
        throw new UsernameNotFoundException("User not found");
    }
}
