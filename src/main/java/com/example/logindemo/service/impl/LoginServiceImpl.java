package com.example.logindemo.service.impl;

import com.example.logindemo.common.Response;
import com.example.logindemo.entity.User;
import com.example.logindemo.service.LoginService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author 24797
 * @version 1.0
 * @description TODO
 * @date 2025/12/13 23:41
 */

@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public Response login(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        // test account
        if (username.equals("test") && password.equals("123456")) {
            return Response.success(200, "login success", new Date());
        } else {
            return Response.error(401, "login failed", new Date());
        }
    }
}
