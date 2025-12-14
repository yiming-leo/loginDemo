package com.example.logindemo.service.impl;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author 24797
 * @version 1.0
 * @description a Mock Testing for returning testing account
 * @date 2025/12/14 15:42
 */
@Service
public class UserServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Mock Test Account 123456
        if (!username.equals("test")) {
            throw new UsernameNotFoundException("User not found");
        }
        //System.out.println("loadUserByUsername called: " + username);
        return User.builder()
                .username(username)
                .password(new BCryptPasswordEncoder().encode("123456"))
                .build();
    }
}