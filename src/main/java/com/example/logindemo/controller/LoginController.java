package com.example.logindemo.controller;

import com.example.logindemo.common.Response;
import com.example.logindemo.entity.User;
import com.example.logindemo.service.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author 24797
 * @version 1.0
 * @description login page with auth
 * @date 2025/12/13 22:34
 */

@RequestMapping("/")
@RestController
public class LoginController {

    @Autowired
    private LoginServiceImpl loginService;

    /**
     * @param user_received request User entity
     * @return com.example.logindemo.common.Response Standard Response return
     * @author 24797
     * @date 2025/12/14 0:43
     */
    @PostMapping("/login")
    public Response login(@RequestBody User user_received) {
        Response response = loginService.login(user_received);
        System.out.println(response);

        if (response.getStatus().equals(200)) {
            return Response.success(200, "login success", new Date());
        } else {
            return Response.error(401, "Unauthorized", new Date());
        }
    }

}
