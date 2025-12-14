package com.example.logindemo.service;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author 24797
 * @version 1.0
 * @description TODO
 * @date 2025/12/14 15:41
 */
public interface UserService {
    UserDetails loadUserByUsername(String username);
}
