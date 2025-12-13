package com.example.logindemo.service;

import com.example.logindemo.common.Response;
import com.example.logindemo.entity.User;

/**
 * @author 24797
 * @version 1.0
 * @description user info's interface
 * @date 2025/12/13 23:19
 */
public interface LoginService {
    Response login(User user);
}
